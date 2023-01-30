package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private void recCombination(int ind, int[] arr, int target, List<Integer> ds, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(ds));
            return;
        }
        if(ind == arr.length) return;

        if(arr[ind] <= target){
            ds.add(arr[ind]);
            recCombination(ind, arr, target-arr[ind], ds, res);
            ds.remove(ds.size()-1);
        }

        recCombination(ind+1, arr, target, ds, res);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recCombination(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        for(List<Integer> com: cs.combinationSum(new int[]{2,3,6,7}, 7)){
            System.out.print(com);
        }
    }
}
