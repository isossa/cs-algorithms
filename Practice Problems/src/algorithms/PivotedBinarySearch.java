package algorithms;

public class PivotedBinarySearch
{
	public static void main(String[] args)
	{
		int[] input = new int[] {5, 6, 7, 8, 9, 0, 1, 2, 3};
		
		System.out.println(solution(input, 0));
	}
	
	public static int solution(int[] input, int target)
	{
		return helper(input, 0, input.length - 1, target);
	}
	
	public static int helper(int[] input, int start, int end, int target)
	{
		if (input == null || input.length < 1)
			return (-1);
		
		if ((end - start) <= 1)
		{
			if (input[start] == target)
			{
				return start;
			}
			else if (input[end] == target)
			{
				return end;
			}
			return -1;
		}
		
		int mid = start + (end - start) / 2;
		
		if (input[mid] == target)
			return mid;
		
		int index = helper(input, start, mid, target);
		
		if (index != -1)
			return index;
		
		index = helper(input, mid + 1, end, target);

		return index;
	}
}
