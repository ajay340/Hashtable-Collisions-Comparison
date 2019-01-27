package HashTable_Collisions_Comparison;

public interface IItem<K,E>{
    //Purpose: Returns the key or the left input of the item
    public K getKey();
    //Purpose: Returns the element or the right input of the item
    public E getElem();
}