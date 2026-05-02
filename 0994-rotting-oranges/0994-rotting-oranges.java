class Solution {
    class Pair{
        int row;int col;int time;
        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        int cfresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    cfresh++;
                }
            }
        }

        int maxTime=0;
        int c=0;
        int rw[]={-1,0,1,0};
        int cl[]={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int colm=q.peek().col;
            int tm=q.peek().time;maxTime=Math.max(maxTime,tm);
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+rw[i];
                int nc=colm+cl[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&vis[nr][nc]==0&&grid[nr][nc]==1){
                    q.add(new Pair(nr,nc,tm+1));
                    vis[nr][nc]=2;
                    c++;
                }
            }
        }
        if(c!=cfresh){
            return -1;
        }
        else{
 return maxTime;
        }
       
        
    }
}