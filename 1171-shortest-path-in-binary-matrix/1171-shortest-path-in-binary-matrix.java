class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // ans=-1;
        // boolean[] visited=new boolean[grid.length]
        Queue<Pair> q=new LinkedList<>();
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1){
            return -1;
        }
        q.add(new Pair(0,0));
        grid[0][0]=1;
        while(!q.isEmpty()){
           Pair p=q.poll();
           int r=p.row;
           int c=p.col;

           int[] rowadd={0,1,1,-1,-1,1,0 ,-1};
           int[] coladd={1,1,0, 1,0 ,-1,-1,-1};

           for(int i=0;i<8;i++){
            int curr_row=rowadd[i]+r;
            int curr_col=coladd[i]+c;

            if(curr_row>=0 && curr_row<grid.length && curr_col>=0 && curr_col<grid[0].length && grid[curr_row][curr_col]==0){
               q.add(new Pair(curr_row,curr_col));
              
               grid[curr_row][curr_col]=grid[r][c]+1;
            }
           }

        }
        if(grid[grid.length-1][grid[0].length-1]==0){
            return -1;
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}