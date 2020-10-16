package algorithms;

import java.util.Arrays;

public class ReplaceElementWithGreatestOnRight
{
	public static void main(String[] args)
	{
		int[] input = solution(new int[] {17,18,5,4,6,1});
		System.out.println(Arrays.toString(input));
	}
	
	public static int[] solution(int[] input)
	{
		if (input == null || input.length == 0)
			return input;
		
		if (input.length > 1)
		{
			int max = max(input, 1);
			
			input[0] = max;
			
			for (int i = 1; i < input.length; i++)
			{
				if (input[i] >= max)
				{
					max = max(input, i + 1);
				}
				input[i] = max;
			}
		}
		input[input.length - 1] = -1;
		return input;
	}
	
	public static int[] slow(int[] input)
	{
		if (input == null || input.length == 0)
			return input;
		
		int start = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i < input.length; i++)
		{
			max = (max < input[i]) ? input[i] : max;
			
			if (i == input.length - 1)
			{
				input[start] = max;
				max = Integer.MIN_VALUE;
				start++;
				i = start;
			}
		}
		input[input.length - 1] = -1;
		return input;
	}

	private static int max(int[] input, int start)
	{
		int max = Integer.MIN_VALUE;
		
		for (int i = start; i < input.length; i++)
		{
			max = (max < input[i]) ? input[i] : max;
		}
		return max;
	}
}
