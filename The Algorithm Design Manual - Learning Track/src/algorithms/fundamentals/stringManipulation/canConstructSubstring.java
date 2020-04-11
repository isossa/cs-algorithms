/*
 * This file implements an algorithm for checking if a substring can be build out of a string by deleting characters.
 *
 * Complexity: Linear-time complexity.
 * Big-Oh Notation: O(S) where S is the size of the text string.
 * Input: A text string STR and a pattern string PATTERN
 * Output: Does STR contain the pattern PATTERN as a substring, and if so where?
 */

/**
 * Implements a pattern matching solver that identifies if a substring can be created out of another string by deleting characters.
 * 
 * @param str     Text string that may or may not contain the patter to match.
 * @param pattern Text pattern to build.
 * @return True if STR contains PATTERN.
 */
public static boolean canConstructSubstring(String str, String pattern)
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
