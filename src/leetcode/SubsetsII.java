package leetcode;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class SubsetsII {
    private void rec(int[] nums, int start, List<Integer> subset, List<List<Integer>> res){
        res.add(new ArrayList<>(subset));

        for(int i=start; i<nums.length; i++){
            if(i!=start && nums[i-1]==nums[i]) continue;
            subset.add(nums[i]);
            rec(nums, i+1, subset, res);
            subset.remove(subset.size()-1);
        }
    }

    private List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        rec(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        SubsetsII s2 = new SubsetsII();
        for(List<Integer> subset: s2.subsetsWithDup(new int[]{1,2,2})){
            System.out.println(subset);
        }
    }
}
