class Solution {
    
    //traversing col wise
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            // Create a new string for each row
            res.add(new String(board[i]));
        }
        return res;
    }
    
    private boolean isValid(int row, int col, int n, char[][] board) {
        
        //checking horizontally left
        for(int i = 0; i <col; i++) {
            if(board[row][i] =='Q') {
                 return false;
            }    
        }
            
        //checking left upper diagonal
        for(int r = row, c = col; r >=0 && c >= 0; r--, c--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        
        //checking left lower diagonal
        for(int r = row, c = col; r < n && c >= 0; r++, c--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        
        return true;
        
    }
    private void solveNQueensUtils(int col, int n, char[][] board, List<List<String>> result) {
        
        //base case
        if(col == n) {
            result.add(construct(board));
            return;
        }
        
        for(int row = 0; row < n; row++) {
            if(board[row][col] == '.') {
                if(isValid(row, col, n, board) == true) {
                    board[row][col] = 'Q';
                    solveNQueensUtils(col + 1, n, board, result);
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