class Solution {
     public int solve(int m,int n,int[][] dp,int[][] obstacleGrid){
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1) return 0;
           
        if(m==0&&n==0){
            return 1;
        }
        if(m<0||n<0){
            return 0;
        }
      
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int up=solve(m-1,n,dp,obstacleGrid);
        int left=solve(m,n-1,dp,obstacleGrid);
        return dp[m][n]=up+left;
    }
   
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
//         int dp[][]=new int[m][n];
//    for(int i=0;i<m;i++){
//     for(int j=0;j<n;j++){
//         dp[i][j]=-1;
//     }
//    }
//      return solve(m-1,n-1,dp,obstacleGrid);


int dp[][]=new int[m][n];
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
             if(obstacleGrid[i][j] == 1) {
            dp[i][j] = 0;
        }
           else if(i==0&&j==0){
                dp[i][j]=1;
            }
            else{
                int up=0;
                int left=0;
                if(i-1>=0){
                    up=dp[i-1][j];
                }
                if(j-1>=0){
                    left=dp[i][j-1];
                }
                dp[i][j]=up+left;
            }
        }
      }
      return dp[m-1][n-1];

    }
}