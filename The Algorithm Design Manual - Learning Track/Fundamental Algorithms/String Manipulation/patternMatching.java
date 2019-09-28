/*
 * Substring pattern matching solver
 *
 * Input: A text string t and a pattern string p
 * Output: Does t contain the pattern p as a substring, and if so where?
 */
 
public static boolean isSubstring(String str, String pattern)
{
	// Initialize counters
	int i = 0, j = 0;

	// Get input strings lengths
	final int STR_LENGTH = str.length();
	final int PATTERN_LENGTH = pattern.length();

	// Process each char in str => O(str.length)
	for (i = 0; i < STR_LENGTH; i++)
	{
		if (pattern.charAt(j) == str.charAt(i))
		{
			if (j == PATTERN_LENGTH - 1)
			{
				return true;
			}

			j++;
		}
	}	
	return false;
}

public static boolean findMatch(String str, String pattern)
{
	// Initialize counters
	int i = 0, j = 0;

	// Get input strings lengths
	final int STR_LENGTH = str.length();
	final int PATTERN_LENGTH = pattern.length();

	// A substring cannot be longer than the substring to whom it is a substring
	for (i = 0; i <= (STR_LENGTH - PATTERN_LENGTH); i++)
	{
		j = 0;

		while ((j < STR_LENGTH) && str.charAt(i + j) == pattern.charAt(j))
		{
			j++;
		}

		if (j == STR_LENGTH)
		{
			return true;
		}
	}

	return false;
}
