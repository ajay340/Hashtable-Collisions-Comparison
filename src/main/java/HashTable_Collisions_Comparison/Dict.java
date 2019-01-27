package HashTable_Collisions_Comparison;

import java.util.ArrayList;
import java.util.Iterator;

public class Dict<K,E> implements IDictionary<K,E> 
{
	private ArrayList<K> keys;
	private ArrayList<E> elems;
	private int size;

	//Purpose: The keys and elements arraylists are set to be empty and the size is set to 0.
	public Dict(){
		keys = new ArrayList<K>();
		elems = new ArrayList<E>();
		size = 0;
	}

	//Purpose: Returns the size variable
	public Integer size(){
		return(size);
	}

	//Purpose: Returns true if the size is equal to 0
	public Boolean isEmpty(){
		return(size == 0);
	}

	//Purpose: returns the elements arraylist iterator
	public Iterator<E> elements(){
		return(elems.iterator());
	}

	//Purpose: returns the keys arraylists iterator
	public Iterator<K> keys(){
		return(keys.iterator());
	}


	//Purpose: Finds the elements in the arraylist keys with the given key
    public E findElement(K k){ 
		int i = keys.indexOf(k);
		if (i > -1){ 
			return(elems.get(i)); 
		}
		else{ 
			return(null); 
		}
	}

	//Purpose: Adds the given key and element into the keys and elements arraylist
	//and increments the size
	public void insert(K k, E e){
		keys.add(k);
		elems.add(e);
		size = size + 1;
	}

	//Purpose: Removes the given key index in the arraylist keys and elements
	//and decrements the size
	public void delete(K k){
		int i = keys.indexOf(k);
		keys.remove(i);
		elems.remove(i);
		size = size - 1;
	}
	
	// Purpose: resets the dictionary back to it's initial state, with size being cleared back to 0, and elems and keys cleared.  
	public void clear() {
		keys = new ArrayList<K>();
		elems = new ArrayList<E>();
		size = 0;
	}
	
}
