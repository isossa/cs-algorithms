/**
* This file implements an algorithm for fast exponentiation.
* 
* Complexity: Logarithmic-time complexity. 
* Big-Oh Notation: O(log_2(N)) where N represents the exponent.
* 
* Input: A base number BASE and an exponent EXP
* Output: BASE^EXP
*/

/**
 * Compute the exponentiale function BASE^EXP
 * 
 * @param base Any integer.
 * @param exp Any positive integer.
 * @return BASE^EXP
 */
public static long fastExponentiation(int base, int exp)
{
  if (exp == 0)
    return 1;

  long x = power(base, exp / 2);

  if (exp % 2 == 0)
    return x * x;
  else
    return base * x * x;
}
