package algorithms;

import java.util.Arrays;

public class MergeSortedArrays
{
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(
				solution(new int[] {1, 2, 3, 4}, 
						new int[] {1, 2, 3, 4})));
	}
	
	private static int[] solution(int[] array1, int[] array2)
	{
		if (array1 == null && array2 == null)
			return new int[] {};
		
		if (array1 == null)
			return array2;
		
		if (array2 == null)
			return array1;
		
		int[] result = new int[array1.length + array2.length];
		int p1 = 0;
		int p2 = 0;
		int index = 0;
		
		while (p1 < array1.length && p2 < array2.length)
		{
			if (array1[p1] < array2[p2])
				result[index++] = array1[p1++];
			else
				result[index++] = array2[p2++];
		}

		while (p1 < array1.length)
		{
			result[index++] = array1[p1++];
		}
		
		while (p2 < array2.length)
		{
			result[index++] = array2[p2++];
		}
		
		return result;
	}

}
