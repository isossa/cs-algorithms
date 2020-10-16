package algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter
{
	public static void main(String[] args)
	{
		System.out.println(solution("ababdc"));
	}
	
	private static char solution(String str)
	{
		Map<Character, Integer> charMap = new LinkedHashMap<>();
		
		for (Character ch : str.toCharArray())
		{
			if (charMap.containsKey(ch))
				charMap.put(ch, charMap.get(ch) + 1);
			else
				charMap.put(ch, 1);
		}
		
		for (Character ch : charMap.keySet())
		{
			if (charMap.get(ch) == 1)
				return ch;
		}
		return ('0');
	}
}
