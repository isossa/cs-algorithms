package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grouping
{
	public static void main(String[] args)
	{
		int[] input = new int[] {3, 5, 8, 0, 8};
		List<int[]> result = new ArrayList<int[]>();
		grouping(input, result);
		
		for (int[] pair : result)
			System.out.println(Arrays.toString(pair));
	}
	
	// Return a list of arrays containing pair of adjacent elements
	static void grouping(int[] input, List<int[]> result)
	{
		groupingHelper(input, 0, input.length - 1, result);
	}

	static void groupingHelper(int[] input, int start, int end, List<int[]> result)
	{
		if (end - start <= 1)
		{
			if (end - start == 0)
			{
				result.add(new int[]{input[start]});
				return;
			}
			if (end - start == 1)
			{
				result.add(new int[]{input[start], input[end]});
				return;
			}
		}
		
		int mid = start + (end - start) / 2;
		groupingHelper(input, start, mid, result);
		groupingHelper(input, mid + 1, end, result);
	}
}
