/**
* This file implements an algorithm for naive exponentiation.
* 
* Complexity: Linear-time complexity. 
* Big-Oh Notation: O(N) where N represents the exponent.
* 
* Input: A base number BASE and an exponent EXP
* Output: BASE^EXP
*/

/**
 * Compute the exponent function of BASE^EXP
 * 
 * @param base Any integer.
 * @param exp Any positive integer.
 * @return BASE^EXP
 */
public static long naiveExponentiation(int base, int exp)
{
  long result = 1;
  for (int i = 0; i < exp; i++)
    result *= base;
  return result;
}
