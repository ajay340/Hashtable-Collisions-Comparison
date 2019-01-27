package HashTable_Collisions_Comparison;


public class DHHash<K, E> extends AHash<K, E> {

	//Purpose: Takes as input a size and a hash comparator
	public DHHash(int s, HashComparator<K> hc) {
		super(s, hc);
	}
	
	// Purpose: Takes a key and returns the numerical of the variable Q - the hash index of the
	//input mod Q.
	public int hashFunc2(K k) {
		int Q = 211;
		int hashVal;
		while (Q >= N) {
			Q--;
		}
		hashVal = Q - (h.hashIndex(k) % Q);
		if (hashVal < 0) {
			hashVal += N;
		}
		return hashVal;
	}

	// Purpose: Adds the keys and elements to the hashtable; if not it adds one
	//to the collisions counter and then uses the hashfunc2 calc number and checks
	//if it is empty or available
	public void insert(K k, E e) { // Assumes this HT is not full
		int i = h.hashIndex(k) % N; // i = index k in the hash table mod(n)
		int j = i; // j is equivalent to i
		boolean done = false; // boolean returns false if it has completed searching for the available index
		while (!done) { // INVARIANT: While searching for empty or available spot
			if (empty(j) || available(j)) { // Checks index of j in array A is empty or available
				A.set(j, new Item<K, E>(k, e)); // sets the j value to inputed key-pair item
				n = n + 1; // increases number of elements in the hash table
				done = true; // sets done to true, illustrating a termination and completion of searching
			} else { // if index is not empty or available
				collisions++; // collisions are incremented by adding 1
				j = (hashFunc2(k) + j) % N; // sets j equal to given number from (hashfunc2(k)+j)mod(N) and loops until searching is complete
			}
			// TERMINATION ARGUEMENT: the loop terminates when a spot is available for the key-pair item. 
			// By doing this, the number of elements in the hash table is increased by 1. However, if there is not a spot available,
			// the number of collisions is incremented by 1, and sets j equal to the given number in hashfunct2, finally looping until 
			// searching is complete. 
		}

	}

		// Purpose: Returns the index of the given key or -1 if there is no such key
		public int find(K k) 
		{
			int i = (h.hashIndex(k) % N); // division method compression map
			int j = i;
			int res = -1;
			boolean done = false; // indicates that the search is done
	
			/*
			 * Processing vector interval [0..n-1] INV: done ==> (empty(j) && res == -1) ||
			 * (available(j) && j == i && res == -1) || (key(j) == k && res == j) || ( j ==
			 * i && res = -1) && !done ==> res == -1 && j in [0..n-1] && [i%N..(j-1)%N] is
			 * processed && -1 <= res <= n-1
			 */
	
			while (!done) {//Invariant: done ==> while processing the vector from 0...n-1
				if (empty(j)) {//if index of j is equivalent to empty
					done = true;//then return done which is equivalent to the boolean true and terminates loop
				} else if (available(j)) {//if j is available
					j = (hashFunc2(k) + j) % N;//sets to the next index of the hash table to (j+1)mod(N)
					if (j == i) {//if j is equivalent to index
						done = true;//this return done which is equivalent boolean true and terminates loop
					}
				} else if (h.keyEqual(key(j), k)) {//if the key at the index j is equivalent to given input key
					res = j;//sets result equivalent to j
					done = true;//this returns done which is equivalent to boolean true and terminates loop
				} else {//if it is not empty, available and keys are not equal
					j = (hashFunc2(k) + j) % N;//then increments the index (hashfunc2(k) + j)mod(N) = j and recursively loops
					if (j == i) {//if j is equivalent to index
						done = true;//this return done which is equivalent boolean true and terminates loop
					}
				}
			}
			return (res);//return results of terminated loop
			//TERMINATION ARGUMENT: will terminate if the index of j is empty, available, key at index j and given key are equivalent
			//and lastly if j==i
		}

}