package leetcode;

import java.util.Arrays;

public class CoinChange {
    private int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int amt=1; amt<=amount; amt++){
            for(int coin: coins){
                if(coin <= amt){
                    dp[amt] = Math.min(dp[amt], dp[amt-coin]+1);
                }
            }
        }

        return dp[amount]>amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] arr = new int[]{1,2,5};
        System.out.print(coinChange.coinChange(arr, 11));
    }
}
