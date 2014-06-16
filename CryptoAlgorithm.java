package cryptojava;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author yeremyturcios
 */
public class CryptoAlgorithm {

	final Map<Integer, Character> alphabetMap = new TreeMap<Integer, Character>(); 
	
	public CryptoAlgorithm(){
		alphabetMap.put(1, 'A');
		alphabetMap.put(2, 'B');
		alphabetMap.put(3, 'C');
		alphabetMap.put(4, 'D');
		alphabetMap.put(5, 'E');
		alphabetMap.put(6, 'F');
		alphabetMap.put(7, 'G');
		alphabetMap.put(8, 'H');
		alphabetMap.put(9, 'I');
		alphabetMap.put(10, 'J');
		alphabetMap.put(11, 'K');
		alphabetMap.put(12, 'L');
		alphabetMap.put(13, 'M');
		alphabetMap.put(14, 'N');
		alphabetMap.put(15, 'O');
		alphabetMap.put(16, 'P');
		alphabetMap.put(17, 'Q');
		alphabetMap.put(18, 'R');
		alphabetMap.put(19, 'S');
		alphabetMap.put(20, 'T');
		alphabetMap.put(21, 'U');
		alphabetMap.put(22, 'V');
		alphabetMap.put(23, 'W');
		alphabetMap.put(24, 'X');
		alphabetMap.put(25, 'Y');
		alphabetMap.put(26, 'Z');
	}
	
	//Converts a string into its numerical equivalent in the alphabet
	public List<Integer> StringToInt(String str){
		String upperCaseString = str.toUpperCase();
		char[] array = upperCaseString.toCharArray();
		List<Integer> arrayInt = new ArrayList<Integer>(); 
		List<Integer> newArrayInt = new ArrayList<Integer>();
		int key = 0;
		char value;
		
		for( int i=0; i<array.length; i++){
			char character = array[i];
			
			for(Map.Entry<Integer, Character> entry: alphabetMap.entrySet()){
				key = entry.getKey();
				value = entry.getValue();
				
				if(character == value){
					break;
				}
			}			
			arrayInt.add(key);
		}										
		return arrayInt; 							
	}
	
	//Converts the key into a list of strings
	public List<Integer> KeyToIntList(String key){
		List<Integer> intKey = StringToInt(key);
		return intKey;
	}
	
	//Encrypts a string
	public String encrypt(String string, String key){		                
                String[] strings = string.split(" ");
                String[] encryptedStrings = new String[strings.length];                
                
                //Counts the number of strings in the orginal string
                int stringCounter = 0;
                
                List<String> stringList = new ArrayList<String>();
		String encryptedString = "";                
		for(String str: strings){
                        
			List<Integer> strToInt = StringToInt(str);
			List<Integer> keyToInt = KeyToIntList(key);
			
			List<Integer> newStrInt = new ArrayList<Integer>();	//Encrypted text in numbers	
			int counter = 0;
			for(int number: strToInt){						
				int newNumber = number + keyToInt.get(counter);
				if(newNumber > 26){
					newNumber = newNumber - 26;
				}//end of if
				
				newStrInt.add(newNumber);
				if(counter == (keyToInt.size() - 1)){
					counter = 0;
				} else {
					counter++;
				}//end of else									
			}//end of for
			
		 
			encryptedString = IntToString(newStrInt);
                        encryptedStrings[stringCounter] = encryptedString;
                        stringCounter++;
			//stringList.add(encryptedString);
		}
                
                StringBuffer result = new StringBuffer();
                for (int i = 0; i < encryptedStrings.length; i++) {
                    result.append( encryptedStrings[i] );
                    result.append(" ");
                }
                
                String encryptedMessage = result.toString();
                
                                
		return encryptedMessage;
	}
	
	//Converts a list of int into a string
	public String IntToString(List<Integer> list){
		String str = "";		
		List<Character> listOfChar = new ArrayList<Character>();
		
		for(int number: list){
			char character = alphabetMap.get(number);
			listOfChar.add(character);
		}
		
		for(char character: listOfChar){
			str += character;		
		}
		
		return str;
	}
	
	//Decrypts a string
	public String decrypt(String string, String key){			
		String[] strings = string.split(" ");
                String[] decryptedStrings = new String[strings.length];                
                
                //Counts the number of strings in the orginal string
                int stringCounter = 0;
                
                
                String decryptedString = "";		
		for(String str: strings){
			List<Integer> strToInt = StringToInt(str);
			List<Integer> keyToInt = KeyToIntList(key);
			
			List<Integer> newStrInt = new ArrayList<Integer>();	//Encrypted text in numbers	
			int counter = 0;
			for(int number: strToInt){						
				int newNumber = number - keyToInt.get(counter);
				if(newNumber < 0){
					newNumber = newNumber + 26;
				}
				
				newStrInt.add(newNumber);
				if(counter == (keyToInt.size() - 1)){
					counter = 0;
				} else {
					counter++;
				}									
			}//end of for
		
			decryptedString = IntToString(newStrInt);
			decryptedStrings[stringCounter] = decryptedString;
                        stringCounter++;
		}
                
                StringBuffer result = new StringBuffer();
                for (int i = 0; i < decryptedStrings.length; i++) {
                    result.append( decryptedStrings[i] );
                    result.append(" ");
                }
                
                String decryptedMessage = result.toString();
                
                                
		return decryptedMessage;
                
	}
	
	
}
 