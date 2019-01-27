package HashTable_Collisions_Comparison;

public class StringComparator implements HashComparator<String> 
{
	int a = 11;
	// Purpose: Does not take input for string comparator
	public StringComparator() { }

	// Purpose: Finds the index in a hashtable of given a key
	public int hashIndex(String k){ 
		int slen = k.length();  // equals the length of a key
		int i = -1; // counter is equal to - 1
		int code = 0; // sets code equal to 0 
		while (i < slen - 1){  // while the the counter i is less than or equal the length of key - 1 
			i = i + 1; // add 1 to counter i 
			code = (int) k.charAt(i) + a * code; // sets code equal to the ith index of the character of the string k, added to k, and 
												// multiplied to the initial code value. 
		}

	return(Math.abs(code)); // returns the absolute value of code.  
	// TERMINATION ARUGEMENT: the loop terminates when one is added to the counter and code is equal to the  ith index of the 
	// character of the string k, added to k, and multiplied to the initial code value. 
	}
	
	// Purpose: Returns true of the first inputed key is equal
	// to the second inputed key
	public Boolean keyEqual(String k1, String k2){ 
		return(k1.equals(k2)); 
	}
	

}
