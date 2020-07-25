package algorithms;

public class Hourglass
{
	public static void main (String[] args)
	{
		int hourglassSize = 3;
		int array[][] = {
				{1, 1, 1, 1, 0, 1, 0, 0},
				{0, 1, 0, 1, 1, 0, 1, 0},
				{1, 1, 0, 0, 0, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 0, 0},
				{0, 1, 0, 1, 0, 1, 0, 0},
				{1, 0, 1, 0, 0, 0, 0, 1}
		};
		print2DArray (array);
		if (hourglassSize % 2 != 0)
		{
			System.out.println ("Max: " + findMaxHourglassSum(array, hourglassSize));
			System.out.println ("Min: " + findMinHourglassSum(array, hourglassSize));
		}
		else
		{
			System.err.println ("Invalid argument. Hourglass size need be odd.");
		}
	}
	
	private static void print2DArray (int[][] array)
	{
		for (int row = 0; row < array.length; row++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				System.out.printf("%3d", array[row][col]);
			}
			System.out.println();
		}
	}
	
	private static int findMaxHourglassSum (int[][] array, int hourglassSize)
	{
		int max = Integer.MIN_VALUE;
		for (int row = 0; row <= array.length - hourglassSize; row++)
		{
			for (int col = 0; col <= array[row].length - hourglassSize; col++)
			{
				int localMax = findHourglassSum (array, row, col, hourglassSize);
				if (max < localMax)
				{
					max = localMax;
				}
			}
		}
		return max;
	}

	private static int findMinHourglassSum (int[][] array, int hourglassSize)
	{
		int min = Integer.MAX_VALUE;
		for (int row = 0; row <= array.length - hourglassSize; row++)
		{
			for (int col = 0; col <= array[row].length - hourglassSize; col++)
			{
				int localMin = findHourglassSum (array, row, col, hourglassSize);
				if (min > localMin)
				{
					min = localMin;
				}
			}
		}
		return min;
	}
	
	private static int findHourglassSum (int[][] array, int startRow, int startCol, int size)
	{	
		int sum = 0;
		int row = startRow;
		int col;
		for (col = startCol; col < startCol + size; col++)
		{
			sum += array[row][col];
		}
		for (row = row + 1; row < startRow + size - 1; row++)
		{
			col = startCol + (size / 2);
			sum += array[row][col];
		}
		for (col = startCol; col < startCol + size; col++)
		{
			sum += array[row][col];
		}
		return sum;
	}
}