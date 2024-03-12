class Solution {
    
    //traversing row wise
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            // Create a new string for each row
            res.add(new String(board[i]));
        }
        return res;
    }
    
    private boolean isValid(int row, int col, int n, char[][] board) {
        
        //checking vertically up
        for(int i = 0; i <row; i++) {
            if(board[i][col] =='Q') {
                 return false;
            }    
        }
            
        //checking left upper diagonal
        for(int r = row, c = col; r >=0 && c >= 0; r--, c--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        
        //checking right upper diagonal
        for(int r = row, c = col; r >=0 && c < n; r--, c++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        
        return true;
        
    }
    private void solveNQueensUtils(int row, int n, char[][] board, List<List<String>> result) {
        
        //base case
        if(row == n) {
            result.add(construct(board));
            return;
        }
        
        for(int col = 0; col < n; col++) {
            
            if(board[row][col] == '.') {
                if(isValid(row, col, n, board) == true) {
                    board[row][col] = 'Q';
                    solveNQueensUtils(row + 1, n, board, result);
                    board[row][col] = '.';     //backtrack
                }
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        
        solveNQueensUtils(0, n, board, result);
        
        return result;
     }
}

//