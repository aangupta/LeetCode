class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        
        int i = 0, j = nCol - 1;
        
        while(i < nRow && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target)
                i++;
            else 
                j--;
        }
        return false;
    
    }
}