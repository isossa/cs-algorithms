package algorithms;

public class PathFinder
{
	public static void main(String [] args)
	{
		int[][] board = {
				{1, 1, 0, 1},
				{0, 0, 0, 1},
				{1, 1, 1, 1}
		};
		
		System.out.println(solution(board, 2, 0));
		printBoard(board);
	}
	
	public static boolean solution(int[][] board, int endRow, int endCol)
	{
		if (board[endRow][endCol] != 1)
			return false;
		
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[row].length; col++)
			{
				if (board[row][col] == 1 && helper(board, row, col, endRow, endCol, 0))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean helper(int[][] board, int row, int col, int endRow, int endCol, int index)
	{
		if (row == endRow && col == endCol)
			return true;
		
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
			return false;
		
		if (board[row][col] != 1)
			return false;
		
		int temp = board[row][col];
		board[row][col] = -1;
		
		boolean found = helper(board, row + 1, col, endRow, endCol, index + 1);
		
		if (found)
			return true;
		
		found = helper(board, row - 1, col, endRow, endCol, index + 1);
		found = helper(board, row, col - 1, endRow, endCol, index + 1);
		found = helper(board, row, col + 1, endRow, endCol, index + 1);
		
		board[row][col] = temp;
		
		return false;
	}
	
	public static void printBoard(int[][] board)
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length; col++)
				System.out.print(board[row][col] + " ");
			System.out.println();
		}
	}
}
