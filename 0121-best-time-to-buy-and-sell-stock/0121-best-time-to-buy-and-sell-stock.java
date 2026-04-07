class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int b=prices[0];
        int s=-1;
        int diff=0;
        for(int i=1;i<n;i++){
            if(prices[i]<b){
                b=prices[i];

            }
            else {
                s=prices[i];
                diff=Math.max(diff,s-b);
            }

        }
        // if(s==-1){
        //     return 0;
        // }
        return diff;
    }
}