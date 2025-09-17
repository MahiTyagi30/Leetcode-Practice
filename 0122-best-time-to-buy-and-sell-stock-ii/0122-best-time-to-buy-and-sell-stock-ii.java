class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        boolean ar[]=new boolean[n];
        int buy=prices[0];
        int profit=0;
        for(int i=0;i<n-1;i++){
            if(prices[i]<prices[i+1]){
                profit=profit+prices[i+1]-prices[i];
            }
            
            
        }
        return profit;
        
    }
}