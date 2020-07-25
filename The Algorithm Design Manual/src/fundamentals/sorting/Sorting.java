package fundamentals.sorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Sorting
{
	/**
	 * This file implements an algorithm for merging N linked lists into one single sorted linked list.
	 * In this implementation, we assume that the size K of each linked list is <<< than the number of linked lists 
	 * there are to merge.
	 * 
	 * Complexity: Linear time complexity
	 * Big-Oh Notation: O(N), where N is the size of the input list.
	 * Input: List of N linkedlists.
	 * Output: One single sorted linked lists.
	 * Author: connect.with.isidore@gmail.com
	 */
	public <T> LinkedList<T> merge(List<LinkedList<T>> list)
	{
	  if (list != null && list.size() > 0)
	  {
	    TreeMap<T, Integer> sortedTree = new TreeMap<T, Integer>();
	    LinkedList<T> merged = new LinkedList<T>();

	    // Insert linked list elements to tree and keep counts of inserted nodes
	    for (LinkedList<T> linkedList : list) // O(N)
	    {
	      Iterator<T> itr = linkedList.iterator();
	      
	      while (itr.hasNext()) // O(K)
	      {
	        T temp = itr.next();

	        if (sortedTree.containsKey(temp))
	        {
	          sortedTree.put(temp, sortedTree.get(temp) + 1);
	        }
	        else
	        {
	          sortedTree.put(temp, 1);
	        }
	      }
	    }

	    // Read tree nodes from smallest to biggest by taking into account number of same single nodes value
	    // inserted

	    Set<T> keys = sortedTree.keySet();

	    Iterator<T> itr = keys.iterator();

	    while (itr.hasNext()) // O(K)
	    {
	      T currentNode = itr.next();
	      Integer counter = sortedTree.get(currentNode); 

	      for (int i = 0; i < counter; i++) // O(N)
	      {
	        merged.add(currentNode);
	      }
	    }
	    
	    return merged;
	  }
	  
	  return null;
	}

	/* 
	 * This file implements the insertion sort algorithm.
	 * 
	 * Complexity: Quadratic-time complexity.
	 * Big-Oh Notation: O(N^2), where N is the input size.
	 * Input: Presumably unsorted array.
	 * Output: Sorted array.
	 */

	/**
	 * Implementation of the insertion sort.
	 * 
	 * @param arrayToSort array to sort.
	 */
	public void insertionSort(int[] arrayToSort)
	{
		final int ARRAY_SIZE = arrayToSort.length;

		// start i at 1 because any single element is already sorted relative to itself
		for (int i = 1; i < ARRAY_SIZE; i++)
		{
			int j = i;
			while ((j > 0) && (arrayToSort[j] < arrayToSort[j - 1]))
			{
				swap(arrayToSort, j, j - 1);
				j = j - 1;
			}
		}
	}

	/**
	 * Helper method that swaps two elements in an array.
	 * 
	 * @param array  array whose elements are to be swapped
	 * @param index1 index1 of the first element to swap
	 * @param index2 index of the other element
	 */
	private void swap(int [] array, int index1, int index2)
	{
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
