package leetcode;

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {
    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=1; i<=numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<i; j++){
                if(j==0 || j==i-1){
                    row.add(1);
                } else{
                    row.add(res.get(i-2).get(j-1) + res.get(i-2).get(j));
                }
            }

            res.add(row);
        }

        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        int n = 5;
        for(List<Integer> row: pt.generate(n)){
            for(Integer item: row){
                System.out.print(item+" ");
            }
            System.out.println();
        }
    }
}
