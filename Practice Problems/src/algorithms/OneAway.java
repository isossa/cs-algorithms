package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * There are three types of edits that can be performed on strings: insert a
 * character, remove a character, or replace a character. Given two strings,
 * write a function to check if they are one edit (or zero) edits away.
 * 
 * Credits: Adapted from Cracking the Coding Interview
 * @author Isidore Sossa
 */
public class OneAway 
{
	public static void main(String[] args)
	{
		String s1 = "bale";
		String s2 = "pale";
		
		System.out.println(solution(s1, s2));
	}
	
	private static boolean solution(String s1, String s2)
	{
		if (s1 == null | s2 == null)
		{
			return false;
		}
		
		if (Math.abs(s1.length() - s2.length()) > 1)
		{
			return false;
		}
		
		// Find longest string and insert its character into a hash map
		Map<Character, Integer> map = new HashMap<>();
		boolean isOneAway;
		if (s1.length() < s2.length())
		{
			map = initializeDictionary(s2);
			isOneAway = solutionHelper(s1, map);
		}
		else
		{
			map = initializeDictionary(s1);
			isOneAway = solutionHelper(s2, map);
		}
		return isOneAway;
	}
	
	private static boolean solutionHelper(String str, Map<Character, Integer> map)
	{
		// Remove characters of shortest string that are in the above-created
		for (int index = 0; index < str.length(); index++)
		{
			if (map.containsKey(str.charAt(index)))
			{
				map.put(str.charAt(index), map.get(str.charAt(index)) - 1);
				
				map.remove(str.charAt(index), 0);
			}
		}
		// Return whether the length of remaining hash map is one or zero
		return (map.size() == 0 || map.size() == 1);
	}
	
	private static Map<Character, Integer> initializeDictionary(String str)
	{
		Map<Character, Integer> map = new HashMap<>();
		
		for (int index = 0; index < str.length(); index++)
		{
			map.put(str.charAt(index), map.getOrDefault(str.charAt(index), 0) + 1);
		}
		return map;
	}
}
