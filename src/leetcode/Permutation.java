package leetcode;


import java.util.List;
import java.util.ArrayList;

public class Permutation {
    public void getPerms(int[] nums, boolean[] isTaken, List<Integer> ds, List<List<Integer>> res){
        if(ds.size() == nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!isTaken[i]){
                ds.add(nums[i]);
                isTaken[i] = true;
                getPerms(nums, isTaken, ds, res);
                ds.remove(ds.size()-1);
                isTaken[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        getPerms(nums, new boolean[nums.length], new ArrayList<>(), res);

        return res;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.print(permutation.permute(new int[]{1,2,3}));
    }
}
