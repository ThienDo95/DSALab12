package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 12 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 04/27/2017
 * Submitted:  04/27/2017
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 04/27/2017
 */
public class HashTable<K, V> implements HashTableInterface<K,V> 
{
	private ChainNode[] table;     
	private int size = 0;          

	public HashTable() 
	{
		table = new ChainNode[3];
	}  

	public boolean tableIsEmpty() 
	{
		return size==0;
	}  

	public int tableLength() 
	{
		return size;
	}  


	public void tableInsert(K key, V value) throws HashException
	{
		if(table[(Integer)value % table.length] == null)
		{
			table[(Integer)value % table.length] = new ChainNode(key, value, null);
		}
		else
		{
			ChainNode<K, V> tail = table[(Integer)value%3];			
			
			while(tail.getNext() != null)
			{
				tail = tail.getNext();
			}
			
			tail.setNext(new ChainNode(key, value, null));		  
		}
		
		size++;
	}
	public boolean tableDelete(K searchKey)
	{
		ChainNode<K, V> cur = null;
		if(size > 0 )
		{
			for(int c = 0; c < table.length; c++)
			{
				if(table[c].getKey().equals(searchKey))
				{
					if(table[c].getNext() == null)
					{
						table[c] = null;
					}
					else
					{
						table[c] = table[c].getNext();
					}
					size--;
					return true;
				}
				else
				{
					cur = table[c];
				}
				
				while(cur!=null)
				{						
					if(cur.getNext().getKey().equals(searchKey))
					{
						if(cur.getNext().getNext() == null)
						{
							cur.setNext(null);
						}
						else
						{
							cur.setNext(cur.getNext().getNext());
						}
						
						size--;
						return true;
					}
					cur = cur.getNext();
				}
			}
		}	
		
		return false;
	}
	public V tableRetrieve(K searchKey){
		ChainNode<K, V> cur= null;
		
		if(size> 0)
		{
			for(int c = 0; c < table.length; c++)
			{
				if(table[c]!=null)
				{
					if(table[c].getKey().equals(searchKey))
					{
						return (V)table[c].getValue();
					}
					else
					{
						cur= table[c];
					}
					
					while(cur.getNext() != null)
					{		  
						if(cur.getNext().getKey().equals(searchKey))
						{													
							return cur.getNext().getValue();
						}
						cur = cur.getNext();
					}
				}
			}
		}	
		return null;
	}
	
	public int hashIndex(K key)
	{
		String s = key.toString();
		int i = 0;
		int firstLetter = 'A';
		int length = s.length();
		int letter = 0;
		
		for(int c = 0, t = length - 1; c < length; c++, t--)
		{
			letter = s.charAt(c);
			i += letter - firstLetter + 1;
			
			if (t == 0)
			{
				i *= 1; 
			}
			else
			{
				i *= 2 << (5 * t - 1);
			}
		}
		
		return i;
	}

}  // end HashTable
