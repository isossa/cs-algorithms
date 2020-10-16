package algorithms;

public class BinarySearch
{
	public static void main(String[] args)
	{
		for (int key : new int[] {1, -2, 3, 5})
		{
			System.out.println(solution(new int[] {1, 2, 3, 4}, key));
		}
	}
	
	public static int solution(int[] input, int key)
	{
		if (input == null)
			return (-1);
		
		int start = 0;
		int end = input.length - 1;
		int mid = start + (end - start) / 2;
		while (start <= end)
		{
			if (input[mid] == key)
				return mid;
			else if (input[mid] < key)
				start = mid + 1;
			else
				end = mid - 1;
			
			mid = start + (end - start) / 2;
		}
		return (-1);
	}
}
