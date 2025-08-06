class Solution {
    public boolean isValidSudoku(char[][] board) {


        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    char temp = board[i][j];
                    board[i][j] = '.';
                    if(!check(board,i,j,temp)) 
                        return false;
                    board[i][j] = temp;
                }
            }
        }

        return true;
    }

    public static boolean check(char[][] board,int row,int col,char store){

        // row check 
        for(int i=0;i<board[0].length;i++){
            if(board[row][i] == store)
                return false;
        }
        
        // col check
        for(int i=0;i<board.length;i++){
            if(board[i][col] == store)
                return false;
        }

        // grid check

        int r = row/3; 
        int c = col/3;

        for(int i=r*3;i<r*3+3;i++){
            for(int j=c*3;j<c*3+3;j++){
                if(board[i][j] == store)
                    return false;
            }
        }

        return true;
    }
}