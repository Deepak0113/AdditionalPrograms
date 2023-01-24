package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    static void subsets(int[]nums, int start, int end, List<Integer> subset, List<List<Integer>> res){
        if(start == end){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[start]);
        subsets(nums, start+1, end, subset, res);
        subset.remove(subset.size()-1);
        subsets(nums, start+1, end, subset, res);
    }

    static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsets(nums, 0, nums.length, subset, res);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
