class Solution {
    public static int  fun(int i,int j,String s,String t){
          if(j>=0&&i<0){
return 0;
        }
        if(j<0){
            return 1;
        }
     
int a=0;
        if(s.charAt(i)==t.charAt(j)){
     return fun(i-1,j-1,s,t)+fun(i-1,j,s,t);
    }
   
return fun(i-1,j,s,t);

 
    }
    public int numDistinct(String s, String t) {
     int n=s.length();
     int m=t.length();
     int dp[][]=new int[n+1][m+1];
     for(int i=0;i<=n;i++){
        dp[i][0]=1;
     }
     for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(s.charAt(i-1)==t.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
            else{
                dp[i][j]=dp[i-1][j];
            }
        }
     }
     return dp[n][m];
    }
}