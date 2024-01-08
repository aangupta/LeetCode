class Solution {
    
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
        
        int[][] temp = new int[nRow][nCol];
        
        for(int[] arr : temp) {
            Arrays.fill(arr, -1);
        }
        
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                if(matrix[i][j] == 0) {
                    markRow(temp, i, nRow, nCol);
                    markCol(temp, j, nRow, nCol);
                }
            }
        }
        
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                if(temp[i][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}