package MidJan;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question4 {
    private void getNumber(int[] deno, int total){
        int[] nums = new int[deno.length];
        int ind = deno.length-1;

        while(total!=0){
            System.out.print(ind+"->"+total+" "+Arrays.toString(nums)+" ");
            if(total>=deno[ind]){
                    nums[ind]++;
                    total -= deno[ind];
            }
            ind--;
            if(ind<0){
                ind = nums.length-1;
            }
        }

        System.out.print(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Question4 q4 = new Question4();
        q4.getNumber(new int[]{1,2,5,10}, 50);
    }
}
