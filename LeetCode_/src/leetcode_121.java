class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int best = 0;
        int min = prices[0];
        for(int  i =0; i < prices.length; i++){
            min = Math.min(prices[i],min);
            best = Math.max(prices[i] - min, best);
        }
        return best;
    }
}