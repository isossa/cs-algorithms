package algorithms;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicatesWithinRange
{
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[][] testcases = {
				{1, 2, 3, 1},
				{5, 3, 2, 7, 5, 3},
				{2, 4, 1, 7, 5, 3, 0, 0},
				{1, 2, 3, 5, 4, 6, 4, 9}
		};
		
		for (int[] nums : testcases)
			System.out.println(solution(nums, 2));
	}
	
	/**
	 * Given an array of integers and an integer k, find out whether there are two
	 * distinct indices i and j in the array such that nums[i] = nums[j] and the
	 * absolute difference between i and j is at most k.
	 * 
	 * Input: nums = [1,2,3,1], k = 3 
	 * Output: true
	 * 
	 * Input: nums = [1,2,3,1,2,3], k = 2 
	 * Output: false
	 * 
	 * @return a boolean value
	 */
	public static boolean solution(int[] nums, int k)
	{
		if (nums == null)
			return false;
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < nums.length; i++)
		{
			if (set.contains(nums[i]))
				return true;
			
			set.add(nums[i]);
			
			if (i >= k)
				set.remove(nums[i - k]);
		}
		return false;
	}

}
