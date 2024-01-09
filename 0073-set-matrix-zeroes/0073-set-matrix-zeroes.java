class Solution {
  
    //Optimal Solution using constant space
    public void setZeroes(int[][] matrix) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        
        int col0 = 1;
        
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0; //marking the ith row
                    
                    if(j != 0) 
                        matrix[0][j] = 0;
                    else 
                        col0 = 0;
                }
            }
        }
        
        for(int i = 1; i < nRow; i++) {
            for(int j = 1; j < nCol; j++) {
                if(matrix[i][j] != 0) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        if(matrix[0][0] == 0) {
            for(int i = 0; i < nCol; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if(col0 == 0) {
             for(int i = 0; i < nRow; i++) {
                matrix[i][0] = 0;
            }
        }
        
       
    }
}