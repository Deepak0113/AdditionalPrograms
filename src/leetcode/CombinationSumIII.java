package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private void combRec(int start, int k, int n, List<Integer> ds, List<List<Integer>> res){
        if(ds.size() == k){
            if(n==0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        for(int i=start; i<=9; i++){
            if(start>n) break;
            ds.add(i);
            combRec(i+1, k, n-i, ds, res);
            ds.remove(ds.size()-1);
        }
    }
    private List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        combRec(1, k, n, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        CombinationSumIII cs3 = new CombinationSumIII();
        for(List<Integer> comb: cs3.combinationSum3(3, 9)){
            System.out.println(comb);
        }
    }
}
