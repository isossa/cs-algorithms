package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch
{
	public static void main(String[] args)
	{
		char[][] matrix = {
				{'G', 'I', 'Z'},
				{'A', 'U', 'T'},
				{'Q', 'S', 'E'}
		};
		
		String[] words = {"GUEST", "FOR", "ARE", "QUIT"};
		List<String> wordFound = new ArrayList<>();
		
		for (String word : words)
		{
			if (findPath(matrix, word))
			{
				wordFound.add(word);
			}
		}
		System.out.println(wordFound);
	}
	
	private static boolean findPath(char[][] matrix, String word)
	{
		/*
		 * Implement DFS to find if there is a path from first character in WORD to last
		 * character in WORD
		 */
		
		// Set up a matrix to keep track of visited letters
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int row = 0; row < visited.length; row++)
		{
			Arrays.fill(visited[row], false);
		}
		
		// Find first occurrence of first character in WORD
		int currentIndex = 0;
		boolean foundRoot = false;
		char nextChar = word.charAt(currentIndex);
		
		int row = 0;
		int col = 0;
		for (row = 0; row < matrix.length; row++)
		{
			if (!foundRoot)
			{
				for (col = 0; col < matrix[row].length; col++)
				{
					if (matrix[row][col] == nextChar)
					{
						foundRoot = true;
						visited[row][col] = true;
						break;
					}
				}
			}
			else
			{
				break;
			}
		}
		
		// Reality begins here
		List<Map<Character, int[]>> neighbors = getNeighbors(matrix, row - 1, col);
		
		nextChar = word.charAt(++currentIndex);
		
		for (int i = 0; neighbors != null && i < neighbors.size(); i++)
		{
			Map<Character, int[]> neighbor = neighbors.get(i);
			Character key = neighbor.keySet().iterator().next();
			if (key == nextChar)
			{
				row = neighbor.get(key)[0];
				col = neighbor.get(key)[1];
				
				if (!visited[row][col])
				{
					if (currentIndex == word.length() - 1)
					{
						return true;
					}
					else
					{
						visited[row][col] = true;
						neighbors = getNeighbors(matrix, row, col);
						nextChar = word.charAt(++currentIndex);
						i = -1; // reset index
					}
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}
	
	/*
	 * Given a matrix and a location represented by ROW and COL, return all the
	 * neighbors of the element at that location
	 */
	public static List<Map<Character, int[]>> getNeighbors(char[][] matrix, int rowIn, int colIn)
	{
		if (isWithinBounds(matrix, rowIn, colIn))
		{
			List<Map<Character, int[]>> neighbors = new ArrayList<>();
			for (int row = rowIn - 1; row <= rowIn + 1; row++)
			{
				if (row > -1 && row < matrix.length)
				{
					for (int col = colIn - 1; col <= colIn + 1; col++)
					{
						if (col > -1 && col < matrix[row].length)
						{
							if (!(row == rowIn && col == colIn))
							{
								Map<Character, int[]> neighbor = new HashMap<>();
								neighbor.put(matrix[row][col], new int[]{row, col});
								neighbors.add(neighbor);
							}
						}
					}
				}
			}
			return neighbors;
		}
		else
		{
			return null;
		}
	}
	
	private static boolean isWithinBounds(char[][] matrix, int rowIn, int colIn)
	{
		return (rowIn > -1 && rowIn < matrix.length && colIn > -1 && colIn < matrix[rowIn].length);
	}
}
