/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 0)
        	return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
    	for(int i = 0; i < prices.length; i++){
    		if(i == 0){
                buy[0] = -prices[0];
                sell[0] = 0;
            }
            else{
            	if(i > 1)
    				buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
    			else
    				buy[i] = Math.max(-prices[1], buy[0]);

    			sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            }
    		
    	}
    	return Math.max(sell[prices.length - 1], buy[prices.length - 1]);
    }
}