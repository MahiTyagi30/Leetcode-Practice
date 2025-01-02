class Solution {
    public int fun(int[][] ar,int i,int j){
        
        if(i==0&&j==0){
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        if(ar[i][j]==1){
            return 0;
        }
        
        int a=fun(ar,i-1,j);
        
       
          int  b=fun(ar,i,j-1);
        
        
        return a+b;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
         int n=obstacleGrid[0].length;
        // int a=fun(obstacleGrid,m-1,n-1);
        // return a;
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // No path through an obstacle
                }
                // if(i==0&&j==0){
                //          dp[i][j]=1;
                // }
               
                else{

                
                if(i>0){
                    dp[i][j]+=dp[i-1][j];
                }
                if(j>0){
                    dp[i][j]+=dp[i][j-1];
                }
                }
            }
        }
        return dp[m-1][n-1];
    }
}