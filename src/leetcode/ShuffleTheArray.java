package leetcode;

import java.util.Arrays;

public class ShuffleTheArray {
    // this approach is optimal with time complexity O(n) and space complexity O(n)
    // public int[] shuffle(int[] nums, int n) {
    //     int[] res = new int[2*n];
    //     int j=0;
    //     for(int i=0; i<n; i++){
    //         res[j++] = nums[i];
    //         res[j++] = nums[i+n];
    //     }

    //     return res;
    // }

    // this approach done inplace using bit manipulation
    // time complexity: O(n)
    // space complexity: O(1)
    // O(1) because we change the input array nums
    private int[] shuffle(int[] nums, int n) {
        for(int i=0; i<n; i++){
            nums[i] = nums[i]<<10;
            nums[i] = nums[i] | nums[i+n];
        }
        n--;
        for(int i=nums.length-1; i>=1; i-=2){
            nums[i] = nums[n] & 1023;
            nums[i-1] = nums[n]>>10;
            n--;
        }

        return nums;
    }

    public static void main(String[] args) {
        ShuffleTheArray shuffleTheArray = new ShuffleTheArray();
        int[] nums = new int[]{2,5,1,3,4,7};
        int n = 3;
        System.out.print(Arrays.toString(shuffleTheArray.shuffle(nums, n)));
    }
}
