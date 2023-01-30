package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private void recCombination(int ind, int[] arr, int target, List<Integer> ds, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<arr.length; i++){
            if(i>ind && arr[i-1]==arr[i]) continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            recCombination(i+1, arr, target-arr[i], ds, res);
            ds.remove(ds.size()-1);
        }
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        recCombination(0, candidates, target, new ArrayList<>(), res);

        return res;
    }
    public static void main(String[] args) {
        CombinationSumII cs2 = new CombinationSumII();
        for(List<Integer> comb: cs2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)){
            System.out.println(comb);
        }
    }
}
