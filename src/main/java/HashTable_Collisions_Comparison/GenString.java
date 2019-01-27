package HashTable_Collisions_Comparison;

import java.util.ArrayList;
import java.util.Random;


public class GenString {
	public static ArrayList<String> tempKeys = new ArrayList<String>();
	public static ArrayList<String> tempElements = new ArrayList<String>();

	// Purpose: Fills the arraylist tempKeys with unique randomly generated string
	// up the given size.
	public static ArrayList<String> uniqueKeys(int size){
		tempKeys.clear();//Clears the arraylist tempKeys
		int i = 0; // counter i is set to 0.  
		while(i <= size-1){ // while the counter is <= to the size of the array list tempKeys - 1
			String newString = generateString(); // creates a newString variable that is a randomly generated string
			if(!tempKeys.contains(newString)){ // if the array list tempKeys does not contain newString 
				tempKeys.add(newString);//it adds newString to the arraylist tempKeys
				i++; // the counter i keeps incremented by 1. 
			}

		}
		return tempKeys; // returns the array list tempKeys.
		// TERMINATION ARGUEMENT: The loop is suppose to terminated when tempKeys[0...i] = randomly generated strings.
		//HOWEVER: There is a statistical anomaly that it will keep randomly generating the same string over and over
		//and the tempKeys will not be filled up and the loop will never terminate.
	}
	// Purpose: Fills the arraylist tempElements with randomly generated string
	//up to the given size.
	public static ArrayList<String> randomElements(int size){
		tempElements.clear();
		int i = 0;
		while(i <= size-1){ // while the counter is <= to the size of the array list tempElements - 1
			tempElements.add(generateString()); // adds a randomly generated string to tempElements
			i++; // counter is continuously incremented by 1. 
		}
		return tempElements; // returns the array list tempElements
		// TERMINATION ARGUEMENT: the loop terminates when tempElements[0...i] = randomly generated strings. 
	}

	// Purpose: Generates a random string.
	public static String generateString() {
		String[] allGivenStrings = {"a", "b" , "c", "d", "d", "e", "f", "g", "h", "i",
									"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
									"u", "v", "w", "x", "y", "z", "A", "B", "C", "D",
									"E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
									"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
									"Y", "Z", "0", "1",  "2", "3", "4", "5", "6", "7",
									"8", "9"};
		Random random = new Random(); // initiates the random variable
		String resultString = ""; // initiates the returned random string. 
		int i = 0; // counter set to 0 
		while(i < 20){  // while it is less than 20 
			String randomChar = allGivenStrings[random.nextInt(allGivenStrings.length - 1)]; // creates a string variable called randomChar
			//that is set to the index of a random number from 0 to the total length of the array of allGivenStrings
			resultString = resultString + randomChar;//resultString is appended to its original value plus randomChar
			i++;// increases the counter 1
		}
		return resultString; // returns a resultrandom string 
		// TERMINATION ARGUEMENT: the loop terminates when the counter is equal to 20 , and random string is the length of 20 characters. 
		
	}

}
