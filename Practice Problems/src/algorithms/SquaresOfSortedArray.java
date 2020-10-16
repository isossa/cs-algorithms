package algorithms;

import java.util.Arrays;

// INCOMPLETE
public class SquaresOfSortedArray
{
	public static void main(String[] args)
	{
		int[] input = new int[] {-5, 1, 2, 5}; 
		System.out.println(Arrays.toString(input));
		solution(input);
		System.out.println(Arrays.toString(input));
	}

	public static void solution(int[] input)
	{
		if (input == null)
			return;
		
		int between = -1;
		
		// Find end of negative array and square array
		for (int i = 0; i < input.length; i++)
		{
			if (input[i] >= 0)
			{
				if (between == -1)
					between = i;
			}
			input[i] *= input[i];
		}
		
		// In case array does not contain negative numbers
		if (between == -1)
			between = input.length;
		
		// Sort elements in range 0 and between
		for (int i = 0, j = between - 1; j >= i; i++, j--)
		{
			if (input[i] >= input[j])
			{
				int temp = input[j];
				input[j] = input[i];
				input[i] = temp;
			}
		}
		
		// Sort entire array : NOT CORRECT YET
		for (int i = between - 1, j = input.length - 1; j >= 0 && i >= 0; j--)
		{
			if (i < j)
			{
				if (input[i] > input[j])
				{
					int temp = input[i];
					input[i] = input[j];
					input[j]= temp;
				}
			}
			else
			{
				if (input[j] > input[i])
				{
					System.out.println(input[i]);
					System.out.println(input[j]);
					int temp = input[i];
					input[i] = input[j];
					input[j]= temp;
					i--;
				}
			}
		}
	}
}
