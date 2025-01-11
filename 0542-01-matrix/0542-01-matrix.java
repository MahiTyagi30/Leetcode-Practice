class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            int nearDist = q.peek()[2];
            q.poll();
            for(int i=-1; i<=1; i++){
                if(i==0)continue;
                if(row+i<n && row+i>=0 && !visited[row+i][col]){
                    mat[row+i][col] = nearDist+1;
                    q.add(new int[]{row+i, col, nearDist+1});
                    visited[row+i][col] = true;
                }
                if(col+i<m && col+i>=0 && !visited[row][col+i]){
                    mat[row][col+i] = nearDist+1;
                    q.add(new int[]{row, col+i, nearDist+1});
                    visited[row][col+i] = true;
                }
            }
        }
        return mat;
    }
}