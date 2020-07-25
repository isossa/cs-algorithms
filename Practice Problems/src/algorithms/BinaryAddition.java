package algorithms;
import java.util.*;

/**
 * Give two arrays A and B representing two binary numbers, compute A + B and
 * store the result of the computation in array C.
 * 
 * e.g. 
 * Input: [1], [1] 
 * Output [1, 0]
 * 
 * Input: [1, 1, 0, 1], [1, 0, 0, 1]
 * Output: [1, 0, 1, 1, 0]
 * 
 * @author Isidore Sossa
 */
public class BinaryAddition
{
    public static void main(String []args)
    {
        int[] A = new int[]{};
        int[] B = new int[]{};
        int[] C = solution(A, B);
        System.out.println(Arrays.toString(C));
    }
    
    public static int[] solution(int[] A, int[] B)
    {
        boolean EOP = false;
        
        int i = A.length - 1;
        int j = B.length - 1;
        int[] C = new int[Math.max(A.length, B.length) + 1];
        int k = C.length - 1;
        int carry = 0;
        
        while (!EOP)
        {
            int sum = 0;
            
            if (i >= 0)
            {
                sum += A[i--];
            }
            
            if (j >= 0)
            {
                sum += B[j--];
            }
            
            sum += carry;
            C[k--] = sum % 2;
            carry = sum / 2;
            
            EOP = (i < 0 && j < 0);
        }
        
        if (carry != 0)
        {
            C[k] = carry;
        }
        
        return C;
    }
}