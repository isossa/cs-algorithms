package algorithms;

// INCOMPLETE
public class MaxConsecutiveOnes
{
	public static void main(String[] args)
	{
		
	}
	
    public int findMaxConsecutiveOnes(int[] nums)
    {
        int maxLength = 0;
        int runningLength = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 1 && runningLength == 0)
                runningLength = 1;
            
            if (i > 0 && nums[i] == 1 && nums[i] == nums[i - 1])
                runningLength++;
            
            if (nums[i] == 0)
            {
                maxLength = (maxLength > runningLength) ? maxLength : runningLength;
                runningLength = 0;
            }
        }
        
        maxLength = (maxLength > runningLength) ? maxLength : runningLength;
        return maxLength;
    }

}
