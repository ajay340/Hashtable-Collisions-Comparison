package HashTable_Collisions_Comparison;

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
