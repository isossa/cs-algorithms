package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubarraySum
{
	public static void main(String[] args)
	{
		System.out.println(solution(new int[] {2, 3, 4, 1, 5}, 2));
		System.out.println(getMaxSum(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 1, 5)), 2));
	}
	
	public static int solution(int[] nums, int k)
	{
		if (nums == null || nums.length < k)
			return -1;
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for (int i = 0; i < nums.length; i++)
		{
			sum += nums[i];
			
			if (i >= (k - 1))
			{
				max = (max < sum) ? sum : max;
				sum -= nums[i - (k - 1)];
			}
		}
		return max;
	}
	
	public static int getMaxSum(List<Integer> input, int k)
	{
	    if (input == null || input.size() < k)
		    return -1;
			
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < input.size(); i++)
		{
			sum += input.get(i);

			if (i >= (k - 1))
			{
				max = (max < sum) ? sum : max;
				sum -= input.get(i - (k - 1));
			}
		}	
		return max;
	}
}
