package leetcode;

public class BestTimeToBuyAndSellStockII {
    private int maxProfit(int[] prices) {
        int profit=0;

        for(int i=1; i<prices.length; i++){
            if(prices[i-1]<prices[i])
                profit += prices[i]-prices[i-1];
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.print(bestTimeToBuyAndSellStockII.maxProfit(arr));
    }
}
