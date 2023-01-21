package leetcode;

import java.util.Arrays;

public class MoveZeros {
    static public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i=0, ind=0;
        while(i<len){
            if(nums[i]!=0){
                nums[ind] = nums[i];
                ind++;
            }
            i++;
        }
        while(ind<len){
            nums[ind] = 0;
            ind++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
