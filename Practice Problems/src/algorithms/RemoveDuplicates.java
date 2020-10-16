package algorithms;

import java.util.Arrays;

public class RemoveDuplicates
{
	public static void main(String [] args)
	{
		int[] input = new int[] {0,0,1,1,1,2,2,3,3,4};
		int length = solution(input);
		
		for (int i = 0; i < length; i++)
		{
			System.out.print(input[i] + " ");
		}
		
		System.out.println("\n" + Arrays.toString(input));
	}
	
	/**
	 * Advantage: Only permutes original array and keeping the first kth elements
	 * distinct.
	 *  
	 * @param input
	 * @return
	 */
	public static int solution(int[] input)
	{
		if (input == null || input.length == 0)
			return 0;
		
		int length = 1;
		int start = 0;
		for (int i = 1; i < input.length; i++)
		{
			if (input[start] != input[i])
			{
				int temp = input[start + 1];
				input[start + 1] = input[i];
				input[i] = temp;
				start++;
				length++;
			}
		}
		return length;
	}
}
