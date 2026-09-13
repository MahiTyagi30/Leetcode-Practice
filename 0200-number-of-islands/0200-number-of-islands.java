
class Solution {
    public static void dfs(int i,int j,int[][] vis,char grid[][],int[] delr,int[]delc){
        int n=grid.length;
        int m=grid[0].length;

        vis[i][j]=1;
        for(int k=0;k<4;k++){
            int nr=i+delr[k];
            int nc=j+delc[k];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]=='1'&&vis[nr][nc]==0){
                dfs(nr,nc,vis,grid,delr,delc);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;

        int m=grid[0].length;
        int delr[]={-1,0,1,0};
        int delc[]={0,1,0,-1};
        int vis[][]=new int [n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&&vis[i][j]==0){
                    c++;
                    dfs(i,j,vis,grid,delr,delc);
                }
            }
        }
        return c;
    }
}