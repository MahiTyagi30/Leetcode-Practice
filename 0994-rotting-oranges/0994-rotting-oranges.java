class Solution {
    public class Pair{
        int r;
        int c;
        int time;
        public Pair(int r,int c,int time){
            this.r=r;
            this.c=c;
            this.time=time;
        }
    }

  
    public int orangesRotting(int[][] grid) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       int n=grid.length;
    //    for(int i=0;i<n;i++){
    //     adj.add(new ArrayList<>());

    //    }
    //    for(int[] e:grid{
    //     int u=e[0];
    //     int v=e[1];
    //     adj.get(u).add(v);
    //     adj.get(v).add(u);
    //    }
    Queue<Pair> q=new LinkedList<>();
    int t=0;
    int fresh =0;
    for(int i=0;i<n;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==2){
                q.add(new Pair(i,j,0));
            }
             if (grid[i][j] == 1) {
                    fresh++;
                }
        }
    }
    int maxt=0;

    while(!q.isEmpty()){
        Pair p=q.poll();
        int r=p.r;
        int c=p.c;
        int time=p.time;
        int[][] dir={
             {-1, 0},
    {1, 0},
    {0, -1},
    {0, 1}
        };
    
    for(int[] d:dir){
        int nr=r+d[0];
        int nc=c+d[1];
        // int newt=time+d[2];
        if(nr >= 0 && nr < n &&
nc >= 0 && nc < grid[0].length&&grid[nr][nc]==1){
            // time=time+1;
            grid[nr][nc] = 2;
               fresh--;
            q.add(new Pair(nr,nc,time+1));
            maxt=Math.max(time+1,maxt);
        }
    }

    }
    if (fresh > 0) {
            return -1;
        }
    return maxt;
        
    }

}