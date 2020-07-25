package algorithms;

import java.util.Arrays;

public class Rotate1DArray 
{
	public static void main (String[] args)
	{
		int[] array = {1, 2, 3, 4}; // -> 2 3 4 5
		long moves = Long.MAX_VALUE;
		long startTime = System.nanoTime();
		
		System.out.println("Executing " + moves + " left rotations\n");
		
		System.out.println(Arrays.toString(leftRotation(array, moves)));
		System.out.println("Non-optimized Runtime:" + (System.nanoTime() - startTime) / Math.pow(10, 9) + " seconds");
		
		startTime = System.nanoTime();
		System.out.println(Arrays.toString(optimizedLeftRotation(array, moves)));
		System.out.println("Optimized Runtime: " + (System.nanoTime() - startTime) / Math.pow(10, 9) + " seconds");
	}
	
	private static int[] leftRotation(int[] array, long moves)
	{
		if (array == null)
			return null;

		if (array.length > 0)
		{
			for (long i = 0; i < moves; i++)
			{
				array = oneLeftRotation(array);
			}
			return array;
		}
		return array;
	}
	
	private static int[] optimizedLeftRotation(int[] array, long moves)
	{
		if (array == null)
			return null;

		if (array.length > 0)
		{
			moves %= array.length;
			
			for (long i = 0; i < moves; i++)
			{
				array = oneLeftRotation(array);
			}
			return array;
		}
		return array;
	}
	
	private static int[] oneLeftRotation (int[] array)
	{
		int temp = array[0];
		int i;
		for (i = 0; i < array.length - 1; i++)
		{
			array[i] = array[i + 1];
		}
		array[i] = temp;
		return array;
	}
}
