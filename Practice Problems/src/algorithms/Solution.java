package algorithms;

import java.io.*;
import java.util.*;

public class Solution {
  
  static List<String> getNeighbors(String[][] grid, int row, int col, char nextChar)
  {
    List<String> neighbors = new ArrayList<>();
    
    neighbors.add(String.format("%s,%d,%d", grid[row][col], row, col));
    
    if ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length))
    {
      if (row + 1 < grid.length)
      {
        if (grid[row + 1][col].equals(Character.toString(nextChar)))
        {
          neighbors.add(String.format("%s,%d,%d", grid[row + 1][col], row + 1, col));
        }
      }

      if (col + 1 < grid[row].length)
      {
        if (grid[row][col + 1].equals(Character.toString(nextChar)))
        {
          neighbors.add(String.format("%s,%d,%d", grid[row][col + 1], row, col + 1));
        }
      }
    }
    return neighbors;
  }
  
  static boolean recursion(String[][] grid, String word, int row, int col, int nextChar, int index,
		  LinkedList<String> list)
  { 
	  List<String> neighbors = getNeighbors(grid, row, col, word.charAt(index));
	  //System.out.println("N -> " + neighbors);
	  //System.out.println(index);
	  
	  if (index == word.length() - 1)
	  {
		  return true;
	  }
	  
	  if (neighbors == null)
	  {
		  return false;
	  }
	  else
	  {
		  for (int i = 1; i < neighbors.size(); i++)
		  {
			  String neighbor = neighbors.get(i);
			  System.out.println(neighbor);
			  int nextRow = Integer.parseInt(neighbor.split(",")[1]);
			  int nextCol = Integer.parseInt(neighbor.split(",")[2]);
			  list.add(neighbor);
			  
			  //if (index + 1 < word.length())
			  //{
			  System.out.println(list);
			  recursion(grid, word, nextRow, nextCol, word.charAt(index + 1), index + 1, list);
			  list.removeLast();
			  //}
		  }
	  }
	return false;
  }

  // DO NOT MODIFY MAIN()
  public static void main(String[] args) {
	  String[][] grid = {
			  {"c", "r", "c", "a", "r", "s"},
			  {"a", "b", "i", "t", "n", "b"},
			  {"t", "f", "n", "n", "t", "i"},
			  {"x", "s", "c", "a", "t", "n"},
			  {"x", "s", "d", "d", "e", "a"},
			  {"s", "q", "w", "x", "s", "p"}
	  };
	  
	  String word = "catx";
	  int index = 1;
	  char nextChar = word.charAt(index);
	  LinkedList<String> list = null;
	  boolean found = true;
	  
	  for (int row = 0; row < grid.length; row++)
	  {
		  for (int col = 0; col < grid[row].length; col++)
		  {
			  if (grid[row][col].equals(Character.toString(word.charAt(0))))
			  {
				  list = new LinkedList<>();
				  list.add(String.format("%s,%d,%d", grid[row][col], row, col));
				  found = recursion(grid, word, row, col, nextChar, index, list);  
			  }
			  
			  if (found)
			  {
				  break;
			  }
		  }
	  }
	  
	  if (!found)
	  {
		  System.out.println("None");
	  }
	  else
	  {
		  if (index == word.length() - 1)
		  {
			  for (String str : list)
			  {
				  System.out.println(str.split(",")[1] + " " + str.split(",")[2]);
			  }
		  }
	  }
	  
	  //findWord(word, grid);
  }
}
