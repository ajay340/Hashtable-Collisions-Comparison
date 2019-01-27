# Hashtable Collisions Comparison

<p align="center">
    <img src="https://img.shields.io/badge/License-MIT-blue.svg" />
    <img src=https://img.shields.io/badge/Made%20with-Java-red.svg />
</p>
<img src="https://github.com/ajay340/Hashtable-Collisions-Comparison/blob/master/pictures/comparison.png" />

---

This is a comparison of the number of collisions caused by inserting keypairs in a hashtable with respect to Linear Probing and Double Hashing methods.

---

## Documentaion
* [Linear Probing](#linear-probing)
* [Double Hashing](#double-hashing)
* [Keypair](#keypair)
* [Data](#data)

## Linear Probing

If the hash index was empty/available, it would insert the keypair; if there was a collison, it would go and check the next hash index on the right and repeat until it found a hash index that was empty/available.

## Double Hashing

The same type of premise as Linear probing, but instead of going to the next hash index if there was a collision, it would go to a calculated hash index and repeat the process until a hash index was found to be empty/available.

The double hashing function:

(Q can be set to any integer, I just used 211.)
```
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
```

## Keypair

The keypair structure (the objects being inserted in the hashtables) have a unique key and random element.

```
public class Item<K,E> implements IItem<K, E>
{
	private K key;
	private E elem;

	//Purpose: Takes as input a key and element and sets them to the private variables
	public Item(K k, E e){ 
		key = k;
		elem = e;
	}
	// Purpose: To get the key or left side of the item
	public K getKey() {
		return(key);
	}
	// Purpose: To get the element or right side of the item
	public E getElem() {
		return(elem);
	}

	

}
```
## Data
<img src="https://github.com/ajay340/Hashtable-Collisions-Comparison/blob/master/pictures/table.PNG" />
<img src="https://github.com/ajay340/Hashtable-Collisions-Comparison/blob/master/pictures/avgdh.png" />
<img src="https://github.com/ajay340/Hashtable-Collisions-Comparison/blob/master/pictures/avglp.png" />
