class Solution {
    //Using extra space O(nRow + nCol)
    private void markRow(int[][] temp, int row, int nRow, int nCol ) {
        for(int i = 0; i < nCol; i++) {
            temp[row][i] = 0;
        }
    }
    
    private  void markCol(int[][] temp, int col, int nRow, int nCol ) {
        for(int i = 0; i < nRow; i++) {
            temp[i][col] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        
        //this will store the index of row and col value, whoose value need to be zero
        int[] row = new int[nRow];
        int[] col = new int[nCol];
        
        Arrays.fill(row, 0);
        Arrays.fill(col, 0);
        
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1; 
                    col[j] = 1;
                }
            }
        }
        
        for(int i = 0; i < nRow; i++) {
            if(row[i] == 1)
                markRow(matrix, i, nRow, nCol);
        }
        
        for(int i = 0; i < nCol; i++) {
            if(col[i] == 1)
                markCol(matrix, i, nRow, nCol);
        }
    }
}