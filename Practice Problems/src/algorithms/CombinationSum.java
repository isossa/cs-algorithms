package algorithms;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum
{
	public static void main(String[] args)
	{
		int[] values = new int[] {2, 3, 6, 7};
		int target = 7;
		List<Integer> candidates = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for (int i : values)
		{
			candidates.add(i);
		}
		
		result = subtract(target, 2, candidates, result, new ArrayList<Integer>());
		System.out.println(result);
	}
	
	private static List<List<Integer>> subtract(int minuend, int subtrahend, List<Integer> values,
			List<List<Integer>> result, List<Integer> runningResult)
	{
		if (subtrahend < 0)
		{
			return null;
		}
		else if (subtrahend == 0)
		{
			result.add(runningResult);
			return subtract(minuend - subtrahend, subtrahend, values, result, runningResult);
		}
		
		if (values.contains(minuend))
		{
			runningResult.add(minuend);
			result.add(runningResult);
			return subtract(minuend - subtrahend, subtrahend, values, result, new ArrayList<Integer>());
		}
		
		runningResult.add(subtrahend);
		subtract(minuend - subtrahend, subtrahend, values, result, runningResult);
		
		return null;
	}

}
