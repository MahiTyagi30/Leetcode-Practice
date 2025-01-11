class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0||i==n-1||j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;

            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1&&vis[nr][nc]==0){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc]=1;

                }
            }
        }
            int cnt=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(vis[i][j]!=grid[i][j]){
                        cnt++;
                    }
                }
            }
        
            return cnt;
        
    }
}