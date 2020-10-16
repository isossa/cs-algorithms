package algorithms;

import java.util.Arrays;

public class SortArrayByParity 
{
	public static void main(String[] args)
	{
		int[] input = new int[] {3, 5, 2};
		System.out.println(Arrays.toString(solution(input)));
	}
	
	public static int[] solution(int[] input)
	{
		if (input == null)
			return input;
		
		int slow = 0;
		for (int fast = 0; fast < input.length; fast++)
		{
			if (input[fast] % 2 == 0)
			{
				int temp = input[slow];
				input[slow] = input[fast];
				input[fast] = temp;
				slow++;
			}
		}
		
		return input;
	}
}
