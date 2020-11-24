package com.jagriti.array;

//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
//Note that you cannot sell a stock before you buy one.
//
//Example 1:
//
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Not 7-1 = 6, as selling price needs to be larger than buying price.
//Example 2:
//
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.

public class StockBuySell_DP_OneTnx {

    public int maxProfit(int[] prices) {

        int n=prices.length;
        if(n<=1)
            return 0;
        int diff = prices[1] - prices[0];
        int curr_prof = diff;
        int max_prof = curr_prof;

        for(int i = 1; i < n - 1; i++)
        {
            // Calculate current diff
            diff = prices[i + 1] - prices[i];

            // Calculate current sum
            if (curr_prof > 0)
                curr_prof += diff;
            else
                curr_prof = diff;

            // Update max sum, if needed
            if (curr_prof > max_prof)
                max_prof = curr_prof;
        }

        return max_prof>0?max_prof:0;
    }
}
