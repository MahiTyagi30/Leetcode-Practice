class Solution {
    public void dfs(int i,int j,int[][] vis,char[][] board,int[] delr,int[] delc){
        vis[i][j]=1;
        int n=board.length;
        int m=board[0].length;
        for(int k=0;k<4;k++){
            int nr=i+delr[k];
            int nc=j+delc[k];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&vis[nr][nc]==0&&board[nr][nc]=='O'){

                dfs(nr,nc,vis,board,delr,delc);
            }

        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int [] delr={-1,0,1,0};
        int [] delc={0,1,0,-1};
        int vis[][]=new int[n][m];
        for(int j=0;j<m;j++){
            if(vis[0][j]==0&&board[0][j]=='O'){
                dfs(0,j,vis,board,delr,delc);
            }
             if(vis[n-1][j]==0&&board[n-1][j]=='O'){
                dfs(n-1,j,vis,board,delr,delc);
            }
        }
 for(int i=0;i<n;i++){
            if(vis[i][0]==0&&board[i][0]=='O'){
                dfs(i,0,vis,board,delr,delc);
            }
             if(vis[i][m-1]==0&&board[i][m-1]=='O'){
                dfs(i,m-1,vis,board,delr,delc);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0&&board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        // return board;
    }
}