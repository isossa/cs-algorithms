package algorithms;

import java.util.Arrays;

public class MergedArrays {

	public static void main(String[] args)
	{
		int[] arr1 = new int[] {1,2,3,4,5,6,7,0,0,0};
		int[] arr2 = new int[] {1, 2, 3};
		
		solution(arr1, arr2);
		System.out.println(Arrays.toString(arr1));
	}

	public static void solution(int[] nums1, int[] nums2)
	{
	    if (nums2.length == 0)
	    	return;
	    
	    int small = nums2.length - 1;
	    int big = 0;
	    
	    while (nums1[big + 1] != 0)
	    	big++;
	    
	    int runner = nums1.length - 1;

	    while (runner >= 0)
	    {
	        if (small < 0 || big >= 0 && nums1[big] > nums2[small])
	        {
	            nums1[runner] = nums1[big];
	            big--;
	        }
	        else
	        {
	            nums1[runner] = nums2[small];
	            small--;
	        }
	        runner--;
	    }
	}
}
