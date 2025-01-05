class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        dp[0][0]=0;
        for(int i=1;i<n+1;i++){
            dp[i][0]=i;
        }
        for(int j=1;j<m+1;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int a=dp[i][j-1]+1;
                    int b=dp[i-1][j]+1;
                    int c=dp[i-1][j-1]+1;
                    int d=Math.min(a,b);
                    
                    dp[i][j]=Math.min(d,c);
                
                }
                
                
            }
        }
        return dp[n][m];
    }
}