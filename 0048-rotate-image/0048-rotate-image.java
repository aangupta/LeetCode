class Solution {
    public void rotate(int[][] matrix) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        
        int[][] temp = new int[nRow][nCol];
        
        int col = nCol -1;
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
               temp[j][col] = matrix[i][j]; 
            }
            col--;
        }
        
         for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
               matrix[i][j] = temp[i][j];
            }
        }
    }
}