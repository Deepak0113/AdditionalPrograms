package leetcode;

public class BestTimeToBuyAndSellStock {
    private int maxProfit(int[] prices) {
        int profit=0;
        int buyPrice=prices[0];

        for(int i=1; i<prices.length; i++){
            if(buyPrice > prices[i]){
                buyPrice = prices[i];
            } else if(prices[i]-buyPrice > profit){
                profit = prices[i]-buyPrice;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.print(bestTimeToBuyAndSellStock.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
