class Solution {
    public List<List<String>> solveNQueens(int n) {
      char [][] board=new char[n][n];
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board.length;j++){
            board[i][j]='.';
        }
      } 
      List<List<String>> ans=new ArrayList<>();
      solve(board,0,ans);
      return ans; 
    }
    public static void solve(char[][] board,int col,List<List<String>> list){
        if(col==board.length){
          list.add(construct(board));
            return;
        }

        for(int row=0;row<board.length;row++){
            if(isSafe(board,col,row)){
                board[row][col]='Q';
                solve(board,col+1,list);
                board[row][col]='.';
                
            }
        }
    }
    public static boolean isSafe(char[][] board,int col,int row){
        int duprow=row;
        int dupcol=col;
        while(row>=0&& col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row--;
            col--;
        }
        col=dupcol;
        row=duprow;
        while(col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            col--;
        }
        row=duprow;
        col=dupcol;
        while(row<board.length&&col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    static List<String> construct(char[][] board) {

        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            internal.add(row);
        }
        return internal;
    }
}