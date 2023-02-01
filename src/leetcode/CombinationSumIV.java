package leetcode;

public class CombinationSumIV {
    private int combs(int[] nums, int target, Integer[] dp){
        if(dp[target] != null)
            return dp[target];

        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= target)
                count += combs(nums, target-nums[i], dp);
        }

        return dp[target] = count;
    }

    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target+1];
        dp[0] = 1;
        return combs(nums, target, dp);
    }
}
