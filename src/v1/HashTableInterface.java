package v1;

public interface HashTableInterface<K,V> 
{

public boolean tableIsEmpty(); 
public int tableLength();
public void tableInsert(K key, V value) throws HashException;
public boolean tableDelete(K searchKey); 
public V tableRetrieve(K searchKey); 
public int hashIndex(K key); 

}  // end HashTableInterface
