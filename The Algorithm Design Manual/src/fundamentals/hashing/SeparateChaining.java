package fundamentals.hashing;

/* 
* This file implements a hashtable using the separate chaining collision resolution scheme.
* 
* Author: connect.with.isidore@gmail.com
*/

import java.util.Iterator;
import java.util.LinkedList;

import javax.naming.OperationNotSupportedException;

public class SeparateChaining
{
  private Object[] list;
  private int size;
  private int numberOfElements;
  private final double LOAD_FACTOR = 0.75;

  /**
  * 
  */
  public SeparateChaining()
  {
    size = 13;
    numberOfElements = 0;
    list = new Object[size];
  }

  /**
  * @param obj
  * @return
  */
  public int insert(Object obj)
  {
    if (isOverloaded())
    {
      rehash();
    }

    // Compute hashCode
    int hashCode = hashCode(obj);

    if (list[hashCode] == null)
    {
      list[hashCode] = new LinkedList<Object>();
      insertHelper(obj, hashCode);
    }
    else if (contains(obj) == -1)
    {
      // Insert obj at hashCode
      insertHelper(obj, hashCode);
    }

    return hashCode;
  }

  /**
  * @param obj
  * @return
  */
  public Object delete(Object obj)
  {
    // Compute hashCode
    int hashCode = hashCode(obj);

    if (list[hashCode] != null)
    {
      @SuppressWarnings("unchecked")
      LinkedList<Object> temp = (LinkedList<Object>) list[hashCode];
      temp.remove(obj);
    }

    return null;
  }

  /**
  * @param obj
  * @return
  */
  public int contains(Object obj)
  {
    int hashCode = hashCode(obj);

    if (list[hashCode] != null)
    {
      @SuppressWarnings("unchecked")
      LinkedList<Object> temp = (LinkedList<Object>) list[hashCode];

      return temp.contains(obj) ? hashCode : -1;
    }

    return -1;
  }

  /**
  * @param obj
  * @return
  */
  public int hashCode(Object obj)
  {
    int hashCode = 0;

    if (!(obj instanceof Integer))
      new OperationNotSupportedException();
    else
      hashCode = ((Integer) obj).intValue() % size; 

    return hashCode;
  }

  /**
  * 
  */
  public void print()
  {
    for (int i = 0; i < size; i++)
    {
      System.out.printf("%2d: ", i);

      if (list[i] == null)
        System.out.printf("{}%n");
      else
      {
        @SuppressWarnings("unchecked")
        LinkedList<Object> temp = (LinkedList<Object>) list[i];
        Iterator<Object> iterator = temp.iterator();

        String values = "{";

        while (iterator.hasNext())
        {
          values += iterator.next().toString() + " ";
        }

        System.out.printf("%s}%n", values.trim());
      }
    }
  }

  /**
  * @param obj
  * @param hashCode
  */
  private void insertHelper(Object obj, int hashCode)
  {
    @SuppressWarnings("unchecked")
    LinkedList<Object> temp = (LinkedList<Object>) list[hashCode];
    temp.add(obj);
    numberOfElements++;
  }

  /**
  * 
  */
  private void rehash()
  {
    Object[] tempList = list;
    size *= 2;

    // Looking for finding the prime number greater than or less
    // than size, whichever is the closest to size
    // Reach out to me if you know how to figure this out.
    // NOTE: Small in/decrement strategy is not really useful.

    list = new Object[size];

    for (int i = 0; i < tempList.length; i++)
    {
      if (tempList[i] != null)
      {
        @SuppressWarnings("unchecked")
        //LinkedList<Object> temp = (LinkedList<Object>) tempList[i];

        Iterator<Object> iterator = ((LinkedList<Object>) tempList[i]).iterator();

        while (iterator.hasNext())
        {
          insert(iterator.next());
        }
      }
    }
  }

  /**
  * @return
  */
  private boolean isOverloaded()
  {
    return numberOfElements * 1.0 / size > LOAD_FACTOR;
  }
}
