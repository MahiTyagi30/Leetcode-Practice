class Solution {
    class Pair{
        int dist;
        int row;
        int col;
        public Pair(int d,int r,int c){
            this.dist=d;
            this.row=r;
            this.col=c;

        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.dist-y.dist);
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;

            }
        }
        dist[0][0]=0;
        pq.add(new Pair(0,0,0));
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(!pq.isEmpty()){
            int diff=pq.peek().dist;
            int r=pq.peek().row;
            int c=pq.peek().col;
            pq.remove();
            if(r==n-1&&c==m-1){
                return diff;
            }
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m){
                    int neweff=Math.max(diff,Math.abs(heights[nr][nc]-heights[r][c]));
                    if(neweff<dist[nr][nc]){
                        dist[nr][nc]=neweff;
                        pq.add(new Pair(neweff,nr,nc));

                    }
                }
            }

        }
        return 0;

        
    }
}