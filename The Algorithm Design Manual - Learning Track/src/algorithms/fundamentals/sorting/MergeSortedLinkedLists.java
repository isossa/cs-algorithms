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

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeMap;

public LinkedList<T> merge(List<LinkedList<T>> list)
{
  if (list != null && list.size() > 0)
  {
    TreeMap<T, Integer> sortedTree = new TreeMap<T, Integer>();
    LinkedList<T> merged = new LinkedList<T>();

    // Insert linkedlist elements to tree and keep counts of inserted nodes
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
