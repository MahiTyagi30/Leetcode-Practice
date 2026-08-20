class Solution {
    public static boolean isPalin(int i,int j,String str){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static int fun(int i,int n ,String str){
        if(i==n){
            return 0;
        }
        int mini=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalin(i,j,str)){
                int cost=1+fun(j+1,n,str);
                mini=Math.min(mini,cost);
            }
        }
        return mini;
    }
    public int minCut(String s) {

        int n=s.length();
        int dp[]=new int[n+1];
        dp[n]=0;
      
        for(int i=n-1;i>=0;i--){
                int mini=Integer.MAX_VALUE;
              for(int j=i;j<n;j++){
            if(isPalin(i,j,s)){
                int cost=1+dp[j+1];
                mini=Math.min(mini,cost);
            }

            
        }
        dp[i]=mini;
        }
        return dp[0]-1;
        
    }

}