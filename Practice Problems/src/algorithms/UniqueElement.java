package algorithms;

import java.util.HashSet;
import java.util.Set;

public class UniqueElement
{
	public static void main(String[] args)
	{
		System.out.println(solution(new int[] {1, 1, 2}));
	}

	private static int solution(int[] nums)
	{
		if (nums == null)
			return (-1);
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int num : nums)
		{
			if (set.contains(num))
			{
				set.remove(num);
			}
			else
			{
				set.add(num);
			}
		}
		return set.iterator().next();
	}
}
