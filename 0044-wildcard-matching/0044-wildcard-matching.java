class Solution {
    public static boolean fun(int i,int j,String s,String t,int n,int m){
        if(i<0&&j<0){
            return true;
        }
        if(j<0){
            return false;
        }
        if(i<0){
            while(j>=0){
                if(t.charAt(j)!='*'){
                    return false;
                }
                j--;
            }
            return true;
        }
        if(s.charAt(i)==t.charAt(j)||t.charAt(j)=='?'){
            return fun(i-1,j-1,s,t,n,m);
        }
        else if(t.charAt(j)=='*'){
           return  fun(i - 1, j, s, t,n,m) || fun(i, j - 1, s, t,n,m);
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
       int n=s.length();
       int m=p.length();
     boolean dp[][]=new boolean[n+1][m+1];
      dp[0][0]=true;
       for(int i=1;i<=n;i++){
        dp[i][0]=false;
       }
       for(int j=1;j<=m;j++){
        if(p.charAt(j-1)=='*'){
            dp[0][j]=dp[0][j-1];
        }
        else{
            dp[0][j]=false;
        }
        
       }
      
       for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                dp[i][j]=dp[i-1][j-1];
            }
            else if(p.charAt(j-1)=='*'){
                dp[i][j]=dp[i-1][j]||dp[i][j-1];
            }
            else{
                dp[i][j]=false;
            }
        }
       }

      return  dp[n][m];
    }
    
   
}