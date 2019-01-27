package HashTable_Collisions_Comparison;

import java.util.Iterator;
import java.util.ArrayList;
public abstract class AHash<K,E> implements IDictionary<K,E>{

    public Item<K, E> AVAILABLE = new Item<K, E>(null, null); // deleted cell item
	public int n; // number of elements in the hash table
	public int N; // size of the array
	public ArrayList<Item<K, E>> A;
    public HashComparator<K> h; // provides hashIndex and Equals
	public int collisions = 0;
	protected abstract int find(K k);

	// Purpose: Takes as input a number s, the size of the array N, and a hash comparator
	public AHash(int s, HashComparator<K> hc){
        n = 0;
		h = hc;
		N = s;
		int i = 0;
		A = new ArrayList<Item<K, E>>(s);
		/*
		 * Processing vector interval [0..s-1] INV: 0 <= i <= s-1 && A[0..i] == null
		 */
		while (i <= s - 1) {//Invariant: while i is <= the size of the array - 1,
			A.add(null);//adds null to the array and will repeat until i is the size of array - 1
			i = i + 1;//increments i by 1
			//TERMINATION ARGUMENTS: Creates array A from 0 to i, setting all values equivalent to null. Upon reaching null = 0 to i...
			//function terminates.
		}
    }
    // Purpose: Return true if index i in the array is "AVAILABLE"
    public boolean available(int i) {
		return (A.get(i) == AVAILABLE);
	}

    // Purpose: Return true if index i in the array is null
	public boolean empty(int i) {
		return (A.get(i) == null);
	}

	// Purpose: Return the key at index i
	public K key(int i) {
		return (A.get(i).getKey());
	}

	
	
	// AUXILARY METHODS
	
	
	// Purpose: Return the element at index i
	public E elem(int i) {
		return (A.get(i).getElem());
	}

	// Purpose: To return the collisions
	public int getCollisions(){
		return collisions;
	}



	
	
	// DICTIONARY METHODS
	
	
	// Purpose: To return n, the size
	public Integer size() {
		return (n);
	}

	// Purpose: To check if the given value is empty
	public Boolean isEmpty() {
		return (n == 0);
	}

	// Purpose: If the arraylist A has another value that is not null or AVAILABLE
	//it adds the element into an element arraylist
	public Iterator<E> elements() {
		Iterator<Item<K, E>> htlooper = A.iterator();
		ArrayList<E> elems = new ArrayList<E>();
		Item<K, E> k;
		while (htlooper.hasNext()) { // while the Array A has a next element
			k = htlooper.next(); // sets the item pair equal to whatever the next item in the Array is. 
			if ((k != null) && (k != AVAILABLE)) { // if the item pair is empty or available, adds the element from the item k into the 
													// element array list.
				elems.add(k.getElem()); // 
			}
		}
		return (elems.iterator()); // Returns the elements iterator.
		// TERMINATION ARGUEMENT: the loop terminates when the keys item pair of the Array list is not empty or available, it adds
		// the element of the key pair k into the array list elems. 
	}

	// Purpose: If the array list A has another value that is not null or AVAILABLE
	//it adds keys into an element array list
	public Iterator<K> keys() {
		Iterator<Item<K, E>> htlooper = A.iterator();
		ArrayList<K> keys = new ArrayList<K>();
		Item<K, E> k;
		while (htlooper.hasNext()) { // while the Array A has a next element 
			k = htlooper.next(); // sets the item pair equal to whatever the next item in the Array is. 
			if ((k != null) && (k != AVAILABLE)) { // If the item pair is empty or available, adds the key from the item k into the keys
												   // array list. 
				keys.add(k.getKey());
			}
		}
		return (keys.iterator()); // Returns the keys iterator. 
		// TERMINATION ARUGEMENT: the loop terminates when the keys item pair of the Array list is not empty or available, it adds
		// the key to the array list and then returns the key. `
	}

	// Purpose: To find the corresponding element with the given key
	public E findElement(K k) {
		int i = find(k);
		if (i < 0) {
			return (null);
		} else {
			return (elem(i));
		}
    }
	
	// Purpose: To delete the element in the given index
    public void delete(K k) {
		int i = find(k);
		if (i > -1) {
			A.set(i, AVAILABLE);
			n = n - 1;
		}
	}
	
    // Purpose: To clear the array list
	public void clear() {
		n = 0; // n is number of elements in hash table and is equal to 0. 
		int i = 0; // i is the index which is 0 
		A = new ArrayList<Item<K, E>>(N);
		/*
		 * Processing vector interval [0..s-1] INV: 0 <= i <= s-1 && A[0..i] == null
		 */
		while (i <= N - 1) { // i is equal to 0 and N is equal to the size of the Array. 
			//While i <= size - 1
			A.add(i, null); // Adds null to the index i in the arraylist A. 
			i = i + 1; // Increments i by 1. 
		}
		// TERMINATION ARGUEMENT: the loop terminates when i is equal to the size of the Array minus one. The Array from 0...i is all 
		// equal to 1.
	}
}