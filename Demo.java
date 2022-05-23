// Coin Change
/*  You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.*/

class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int dp[]=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++)
            dp[i]=Integer.MAX_VALUE;
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(coins[j]<=i)
                {
                    int sub=dp[i-coins[j]];
                    if(sub!=Integer.MAX_VALUE && sub+1<dp[i])
                        dp[i]=sub+1;
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE)
            return -1;
        else
            return dp[amount];
        
    }
}