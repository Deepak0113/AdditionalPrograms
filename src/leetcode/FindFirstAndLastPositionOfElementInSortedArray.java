package leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    private void binarysearch(int[] nums, int target, int start, int end, int[] res){
        if(start>end){
            return;
        }
        int mid = (end+start)/2;
        if(nums[mid] == target){
            if(res[0]==-1 || mid<res[0]){
                res[0] = mid;
            }
            if(res[1]==-1 || mid>res[1]){
                res[1] = mid;
            }

            if(mid-1>=0 && nums[mid-1]==target)
                binarysearch(nums, target, start, mid-1, res);
            if(mid+1<nums.length && nums[mid+1]==target)
                binarysearch(nums, target, mid+1, end, res);
        }
        if(nums[mid] > target){
            binarysearch(nums, target, start, mid-1, res);
        }
        if(nums[mid] < target){
            binarysearch(nums, target, mid+1, end, res);
        }
    }

    private int[] searchRange(int[] nums, int target) {
        int[] res ={-1,-1};
        //int start=0, end=nums.length-1, mid=(end-start)/2;

        binarysearch(nums, target, 0, nums.length-1, res);
        return res;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        int[] res = obj.searchRange(arr, target);
        System.out.print(Arrays.toString(res));
    }
}
