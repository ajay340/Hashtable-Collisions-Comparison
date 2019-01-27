package HashTable_Collisions_Comparison;

public interface HashComparator<K> 
{
	// Purpose: takes in as input a key and returns the k value location in the hash table. 
	public int hashIndex(K k);
	
	// Purpose: takes in as inputs two keys, K1 and K2, and returns true or false depending on if K1 and K2 are equal.
	public Boolean keyEqual(K k1, K k2);
	

}
