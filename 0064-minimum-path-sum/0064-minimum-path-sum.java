class Solution {
    public int solve(int m,int n,int[][] dp,int[][] grid){
        if(m==0&&n==0){
            return grid[m][n];
        }
       if(m<0 || n<0){
    return (int)1e9; // or Integer.MAX_VALUE
}
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int up=grid[m][n]+solve(m-1,n,dp,grid);
        int left=grid[m][n]+solve(m,n-1,dp,grid);
        return dp[m][n]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
       int dp[][]=new int[m][n];
   for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
        dp[i][j]=-1;
    }
   }
     return solve(m-1,n-1,dp,grid);
    }
}
