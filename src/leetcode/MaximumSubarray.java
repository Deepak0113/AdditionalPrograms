package leetcode;

public class MaximumSubarray {
    static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for(int i=0; i<nums.length; i++){
            if(currSum < 0){
                currSum = 0;
            }
            currSum+=nums[i];
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(arr));
    }
}
