package fundamentals.math;
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
 * Compute the exponential function BASE^EXP
 * 
 * @param base Any integer.
 * @param exp Any positive integer.
 * @return BASE^EXP
 */
public class MathematicalObject
{
	public static long fastExponentiation(int base, int exp)
	{
	  if (exp == 0)
	    return 1;

	  long x = (long) Math.pow(base, exp / 2);

	  if (exp % 2 == 0)
	    return x * x;
	  else
	    return base * x * x;
	}

	/**
	* This file implements an algorithm for matrix multiplication.
	* 
	* Complexity: Cubic-time complexity. Big-Oh Notation: O(ROW_A * COL_B * COL_A)
	* where ROW_ and COL_ represent number of rows and columns respectively. 
	* 
	* Input: Two matrices A and B with dimensions ROW_A * COL_A and 
	* ROW_B * COL_B, respectively. Presumably COL_A equals COL_B.
	* Output: The matrix product of A and B.
	*/

	/**
	 * Multiply two matrices.
	 * 
	 * @param A Leftmost matrix operand.
	 * @param B Rightmost matrix operand
	 * @return Product of A and B.
	 */
	public static int[][] multiplyMatrix(int[][] A, int[][] B)
	{
	  int row_A = A.length;
	  int col_A = A[0].length;
	  int row_B = B.length;
	  int col_B = B[0].length;

	  if (col_A != row_B)
	  {
	    return null;
	  }

	  int[][] C = new int[row_A][col_B];

	  for (int i = 0; i < row_A; i++)
	  {
	    for (int j = 0; j < col_B; j++)
	    {
	      C[i][j] = 0;
	      for (int k = 0; k < col_A; k++)
	      {
	        C[i][j] += A[i][k] * B[k][j];
	      }
	    }
	  }		
	  return C;
	}
	
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
}
