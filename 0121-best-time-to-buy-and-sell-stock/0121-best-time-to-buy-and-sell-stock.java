class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int buyprice = prices[0];
        for(int i=0; i<prices.length; i++){
            int curprofit = prices[i] - buyprice;
            if(curprofit > maxprofit){
                maxprofit = curprofit;
            }
            if(prices[i]<buyprice){
                buyprice = prices[i];
            }
        }  
         return maxprofit; 
    }
}