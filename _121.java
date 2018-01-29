/**
 SOLUTION: array, math
 NOTES:
 1. core: find the minimum and the maximum after minimun;
 2. do not need to record maximum number, just record the difference.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int max_Output = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min) min = prices[i];
            if(prices[i]-min > max_Output) max_Output = prices[i] - min;
        }
        return max_Output;
    }
}
