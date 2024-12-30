class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int r=0;r<board.length;r++){
            for(int col=0;col<board[0].length;col++){
                if(board[r][col]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,r,col,c)){
                            board[r][col]=c;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[r][col]='.';
                            }
                        }
                    }
                        return false;
                    
                }
            }
           
        }
        return true;
    }


    public boolean isValid(char[][] board,int r,int col,char c){
        for(int i=0;i<9;i++){
            if(board[r][i]==c||board[i][col]==c){
                return false;
            }
            int sr=(r/3)*3;
            int sc=(col/3)*3;
            if(board[sr+i/3][sc+i%3]==c){
                return false;
            }
        }
        return true;
    }

}