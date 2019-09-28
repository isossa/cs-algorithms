/*
 * This file implements two different substring pattern matching solver algorithms
 *
 * Complexity: Quadratic-time complexity.
 * Big-Oh Notation: O(S*P) where S is the size of the text string and P the size of the pattern to match. Presumably, P <= S.
 * Input: A text string STR and a pattern string PATTERN
 * Output: Does STR contain the pattern PATTERN as a substring, and if so where?
 */

/**
 * Implements a pattern matching solver.
 * 
 * @param str     Text string that may or may not contain the patter to match.
 * @param pattern Text pattern to match.
 * @return True if STR contains PATTERN.
 */
public static boolean isSubstring(String str, String pattern)
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
