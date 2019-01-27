package HashTable_Collisions_Comparison;

import java.util.ArrayList;

public class HashTableTest {

	public static HashComparator<String> scomp = new StringComparator();
	public static LPHash<String, String> LPHashTable = new LPHash<String, String>(10007, scomp);
	public static DHHash<String, String> DHHashTable = new DHHash<String, String>(10007, scomp);
	public static ArrayList<String> Keys = new ArrayList<String>();
	public static ArrayList<String> Elements = new ArrayList<String>();

	// Purpose: Returns the number of collisions by adding items in the Keys
	// and elements array lists to the linear probing hashtable
	public static int LPCollisionFinder(int size) {
		int i = 0; // set counter = 0
		while (i <= size - 1) { // while the counter is less than or equal to the size - 1
			LPHashTable.insert(Keys.get(i), Elements.get(i)); // inserts the index of the keys and the index of the
																// elements into LPHashTable
			i++; // increments the counter by 1.
		}
		// TERMINATION ARGURMENET: terminates when the counter is greater than or equal to  size  - 1. 
		int numCol = LPHashTable.getCollisions(); // sets numCol to the number of collisions in the LPHashTable
		LPHashTable.clear(); // clears the Hashtable
		return numCol; // returns the number of collisions.
	}

	// Purpose: Returns the number of collisions by adding items in the Keys
	// and elements arraylists to the double hashing hashtable
	public static int DHCollisionFinder(int size) {
		int i = 0; // counter = 0 
		while (i <= size - 1) { // while the counter is less than or equal to size - 1
			DHHashTable.insert(Keys.get(i), Elements.get(i)); // inserts the index of the keys and the index of the
			// elements in DHashTable. 
			i++; // increments the counter by 1. 
		}
		// TERMINATION ARGUEMENT: terminates when the counter is greater than or equal to  size  - 1. 
		int numCol = DHHashTable.getCollisions();
		DHHashTable.clear();
		return numCol;
	}

	// Purpose: Prints out the number of collisions with linear probing and double
	// hashing with the given size 1000 to 10000.
	public static void main(String[] args) {
		int N = 1000; // sets the size of the Array list to 1000. 
		while (N <= 10000) { // while the size of the Array list is less than or equal to 1000
			Keys.clear(); // clears the key array list 
			Elements.clear(); // clears the element array list. 
			Keys = GenString.uniqueKeys(N); // sets keys equal to an array list of unique keys 
			Elements = GenString.randomElements(N); // sets elements equal to an array list of random elements 
			int LPCol = LPCollisionFinder(N); // returns the number of collisions with the given LPHash table size.
			System.out.println("Linear Probing Collisions with " + N + " keypairs in table: " + LPCol); // prints out the number of   
			// collisions with linear probing. 
			int DHCol = DHCollisionFinder(N); // returns the number of collisions with the given DHHash table. 
			System.out.println("Double Hashing Collisions with " + N + " keypairs in table: " + DHCol); // prints out the number of 
			// collisions with Double Hashing. 
			System.out.println("\n"); // prints out a new line. 
			N = N + 1000; // sets N equal to the array list added to 1000
			// TERMINATION ARGUEMENT: the loop terminates when the Size of the Array list is greater than 10000.
		}
	}

}