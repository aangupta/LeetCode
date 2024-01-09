class Solution {
    
    //Inplace
    public void rotate(int[][] matrix) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        
        //step 1 : Transpose the matrix
        for(int i = 0; i < nRow; i++) {
            for(int j = i + 1; j < nCol; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
          
        }
        
        //step 2: flip the matrix horizontally
        for(int i = 0; i < nRow; i++) {
            int start = 0;
            int end = nCol-1;
            
            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}