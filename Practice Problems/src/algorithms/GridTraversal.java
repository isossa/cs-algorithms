package algorithms;

// NOT COMPLETED

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GridTraversal 
{
	public static void main(String[] args)
	{
		int[][] array = {	{1, 0, 0, 0},
							{1, 0, 0, 0},
							{1, 1, 1, 1},
							{0, 0, 0, 1}
						};
		
		findPath(array);
		//List<Pair> l = getCoordinatesBFS(array);
		//System.out.println(l);
	}
	
	public static void findPath(int[][] array)
	{
		if (array == null || array.length == 0)
			return;
		
		Queue<Pair> queue = new LinkedList<>();
		Pair parent;
		
		// Find the first occurrence of 1
		// This is the starting point
		for (int row = 0; row < array.length; row++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				if (array[row][col] == 1)
				{
					queue.add(new Pair(row, col));
					break;
				}
			}
		}
		
		while (!queue.isEmpty())
		{
			System.out.println(queue);
			parent = queue.remove();
			//System.out.println(parent);
			
			Pair pair;
			
			if (parent.y + 1 < array[parent.x].length)
			{
				if (array[parent.x][parent.y + 1] == 1)
				{
					pair = new Pair(parent.x, parent.y + 1);
					if (!queue.contains(pair))
						queue.add(pair);
				}
			}
			
			if (parent.x + 1 < array.length)
			{
				if (array[parent.x + 1][parent.y] == 1)
				{
					pair = new Pair(parent.x + 1, parent.y);
					if (!queue.contains(pair))
						queue.add(pair);
				}
			}
		}
	}
	
	public static List<Pair> getCoordinatesBFS(int[][] array)
	{
		if (array == null || array.length == 0)
			return null;
		
		List<Pair> coordinatesBFS = new LinkedList<>();
		Pair parent = new Pair(0, 0);
		coordinatesBFS.add(parent);
		
		int index = 0;
		
		while (index < array.length * array[0].length)
		{
			parent = coordinatesBFS.get(index);
			
			Pair pair;
			
			if (parent.y + 1 < array[parent.x].length)
			{
				pair = new Pair(parent.x, parent.y + 1);
				if (!coordinatesBFS.contains(pair))
					coordinatesBFS.add(pair);
			}
			
			if (parent.x + 1 < array.length)
			{
				pair = new Pair(parent.x + 1, parent.y);
				if (!coordinatesBFS.contains(pair))
					coordinatesBFS.add(pair);
			}
			index++;
		}
		return coordinatesBFS;
	}
	
	public static void BFSTraversal(int[][] array)
	{
		printArray(array, GridTraversal.getCoordinatesBFS(array));
	}
	
	public static void printArray(int[][] array, List<Pair> coordinates)
	{
		for (Pair p : coordinates)
			System.out.print(array[p.x][p.y] + " ");
	}
}

class Pair
{
	int x;
	int y;
	
	Pair (int xIn, int yIn)
	{
		x = xIn;
		y = yIn;
	}
	
	public int hashcode()
	{
		return x * y;
	}
	
	public boolean equals(Object p)
	{
		if (p == null || p.getClass() != this.getClass())
			return false;
		
		if (this == p)
			return true;
		
		Pair temp = (Pair) p;
		return (temp.x == this.x && temp.y == this.y);
	}
	
	public String toString()
	{
		return String.format("(%d, %d)", x, y);
	}
}
