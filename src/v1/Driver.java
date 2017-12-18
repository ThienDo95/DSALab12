package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 12 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 04/24/2017
 * Submitted:  04/24/2017
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 04/24/2017
 */
public class Driver
{
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException
	{

		HashTable<String, Integer> t = new HashTable<String, Integer>();
		
		// Since A - Z = 65 - 90 
		// If value >= 65 and value <=90, just subtract value by 65 and it will map 1 to 26 to letters
		
		int i;
		do
		{
			System.out.println("\n"+"Application's Options: ");
			System.out.println("                       ");
			System.out.println("1. Insert a symbol key with an associated value in the table");
			System.out.println("2. Delete a symbol from the table");
			System.out.println("3. Retrieve and display the value associated with a symbol key in the table");
			System.out.println("4. Display the hash index of a symbol key");
			System.out.println("5. Exit");
			System.out.println("                       ");
			System.out.println("Choose your option: " + "\n");
			String input = stdin.readLine().trim();
			System.out.println(input);
			i = Integer.parseInt(input);

			if (i > 0 && i < 7)
			{
				switch(i)
				{
					case 1:
						System.out.println("Enter a key: ");
						String c1 = stdin.readLine();
						System.out.println("Enter a value: ");
						String c1a = stdin.readLine();
						int value = Integer.parseInt(c1a);
						
						t.tableInsert(c1,value);
						System.out.println(c1 + " has been added.");
						break;
					case 2:
						System.out.println("Enter a symbol for delete: ");
						String c2 = stdin.readLine().trim();
						boolean isDelete = t.tableDelete(c2);
						
						if(isDelete)
						{
							System.out.println(c2 + " has been deleted.");
						}
						else
						{
							System.out.println(c2 + " does not exist.");
						}
						break;
					case 3:
						System.out.println("Enter a symbol to retrieve: ");
						String c3 = stdin.readLine().trim();
						Integer val = t.tableRetrieve(c3);
						
						if(val != null)
						{
							System.out.println(c3 + " has the value of: " + val);
						}
						else
						{
							System.out.println(c3 + " does not exist.");
						}
						break;
					case 4:
						System.out.println("Enter a symbol to return index: ");
						String c4 = stdin.readLine().trim();
						int index = t.hashIndex(c4);
						
						if(index > 0)
						{
							System.out.println(c4 + " has index of: " + index);
						}
						else
						{
							System.out.println(c4 + " does not exist.");
						}
						break;
					case 5:
						System.out.print("Good Bye");
						break;			
				}
			}
		}while(i < 5 || i > 5);
	}

}


