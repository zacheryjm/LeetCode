class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        
        int maxProfit = 0, minVal = prices[0];
        
        for(int i = 1; i < prices.length; ++i) {
            
            if(prices[i] < minVal) {
                minVal = prices[i];
            }
            else {
                maxProfit = Math.max(maxProfit, prices[i] - minVal);
            }
        }
        
        return maxProfit;
        
    }
}