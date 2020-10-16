package algorithms;

import java.util.Arrays;

public class ProductArray
{
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(solution(new int[] {1, 2})));
	}

	private static int[] solution(int[] nums)
	{
		if (nums == null || nums.length == 0 || nums.length == 1)
			return new int[0];
		
		int[] result = new int[nums.length];
		
		result[0] = 1;
		
		for (int i = 1; i < nums.length; i++)
		{
			result[i] = result[i - 1] * nums[i - 1];
		}
		
		int value = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--)
		{
			result[i] *= value;
			value *= nums[i]; 
		}
		
		return result;
	}
}
