package algorithms;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2
{
	public static void main(String [] args)
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
			if (solution(matrix, word))
			{
				wordFound.add(word);
			}
		}
		
		System.out.println(wordFound);
	}
	
	public static boolean solution(char[][] board, String word)
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[row].length; col++)
			{
				if (board[row][col] == word.charAt(0) 
						&& helper(board, row, col, word, 0))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean helper(char[][] board, int row, int col, String word, int index)
	{
		if (index == word.length())
			return true;
		
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
			return false;
		
		if (word.charAt(index) != board[row][col])
			return false;
		
		char temp = board[row][col];
		board[row][col] = '*';
		
		if (   helper(board, row + 1, col - 1, word, index + 1)
			|| helper(board, row + 1, col, word, index + 1)
			|| helper(board, row + 1, col + 1, word, index + 1)
			|| helper(board, row, col - 1, word, index + 1)
			|| helper(board, row, col + 1, word, index + 1)
			|| helper(board, row - 1, col - 1, word, index + 1)
			|| helper(board, row - 1, col, word, index + 1)
			|| helper(board, row - 1, col + 1, word, index + 1)
			)
		{
			board[row][col] = temp;
			return true;
		}
		
		board[row][col] = temp;
		return false;
	}
	
	public boolean exist(char[][] board, String word)
	{
        boolean result = false; 
		result = search(board, word, 0, 0, 0, result); 
		return result; 
    }
    
    private static boolean search(char[][] board, String word, int charIndex, int icurrent, int jcurrent, boolean result)
    {
		if ( charIndex == 0 )
		{
			for ( int i = 0; i < board.length; i++ )
			{
				for ( int j = 0; j < board[i].length; j++ )
				{
					if ( board[i][j] == word.charAt(charIndex) )
					{
						board[i][j] = ' '; 
						result = search(board, word, charIndex+1, i, j, result); 
						if ( result )
						{
							return result; 
						}
					}
				}
			}
			return result; 
		}
		else if ( charIndex == word.length() )
		{
			return true; 
		}
		else
		{
			board[icurrent][jcurrent] = ' '; 
			
			if ( jcurrent != board[icurrent].length-1 && board[icurrent][jcurrent+1] == word.charAt(charIndex) )
			{
				result = search(board, word, charIndex+1, icurrent, jcurrent+1, result); 
				if ( result )
				{
					return result; 
				}
			}
			if ( icurrent != board.length-1 && board[icurrent+1][jcurrent] == word.charAt(charIndex) )
			{
				result = search(board, word, charIndex+1, icurrent+1, jcurrent, result); 
				if ( result )
				{
					return result; 
				}
			}
			if ( jcurrent != 0 && board[icurrent][jcurrent-1] == word.charAt(charIndex) )
			{
				result = search(board, word, charIndex+1, icurrent, jcurrent-1, result); 
				if ( result )
				{
					return result; 
				}
			}
			if ( icurrent != 0 && board[icurrent-1][jcurrent] == word.charAt(charIndex) )
			{
				result = search(board, word, charIndex+1, icurrent-1, jcurrent, result); 
				if ( result )
				{
					return result; 
				}
			}
			board[icurrent][jcurrent] = word.charAt(charIndex-1); 
		}
		return result;
	}
}
