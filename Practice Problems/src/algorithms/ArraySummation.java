package algorithms;

public class ArraySummation
{
	public static void main(String[] args)
	{
		System.out.println(solution(new int[] {0, 1, 2, 3, 4}));
	}
	
	public static int solution(int[] input)
	{
		return helper(input, 0, input.length);
	}
	
	private static int helper(int[] input, int start, int end)
	{
		if (start == end)
			return 0;
		
		return input[start] + helper(input, start + 1, end);
	}
}
