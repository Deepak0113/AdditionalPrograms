package leetcode;

public class ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] nums) {
        int prev = 0;
        int count = 0;

        for(int i=2; i<nums.length; i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                prev++;
                count += prev;
            } else{
                prev = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
