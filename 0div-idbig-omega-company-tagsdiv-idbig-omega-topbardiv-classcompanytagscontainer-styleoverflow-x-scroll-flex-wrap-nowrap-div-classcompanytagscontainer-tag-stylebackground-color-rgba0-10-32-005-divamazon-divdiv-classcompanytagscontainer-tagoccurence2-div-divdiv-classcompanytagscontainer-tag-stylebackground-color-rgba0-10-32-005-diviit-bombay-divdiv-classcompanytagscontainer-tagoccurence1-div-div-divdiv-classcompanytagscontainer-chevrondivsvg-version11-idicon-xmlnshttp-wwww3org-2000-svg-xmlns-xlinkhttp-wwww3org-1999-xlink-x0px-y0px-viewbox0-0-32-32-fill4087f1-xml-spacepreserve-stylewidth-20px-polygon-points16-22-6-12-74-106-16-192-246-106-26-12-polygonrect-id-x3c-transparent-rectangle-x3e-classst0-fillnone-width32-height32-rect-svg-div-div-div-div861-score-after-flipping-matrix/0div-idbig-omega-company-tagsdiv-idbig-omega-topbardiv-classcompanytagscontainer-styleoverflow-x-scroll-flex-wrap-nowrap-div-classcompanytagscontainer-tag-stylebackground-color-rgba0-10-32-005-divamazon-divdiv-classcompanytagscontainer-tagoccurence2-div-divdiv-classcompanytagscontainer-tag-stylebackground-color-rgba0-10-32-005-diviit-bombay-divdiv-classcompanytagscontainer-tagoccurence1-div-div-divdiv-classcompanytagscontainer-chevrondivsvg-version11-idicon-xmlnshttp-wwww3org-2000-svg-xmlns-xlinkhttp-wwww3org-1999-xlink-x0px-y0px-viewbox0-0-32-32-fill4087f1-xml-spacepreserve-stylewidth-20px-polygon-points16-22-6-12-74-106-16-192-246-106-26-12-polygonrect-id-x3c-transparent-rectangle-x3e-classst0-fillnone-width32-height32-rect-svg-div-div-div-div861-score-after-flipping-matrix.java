class Solution {
    // Solution 1 modified the input array
    public int matrixScore(int[][] grid) {
        int noRows = grid.length;
        int noCols = grid[0].length;
        
        //traverse the first col and if the MSB value is zero flip it to 1
        for(int row = 0; row < noRows; row++) {
            if(grid[row][0] == 0) {
                
                //flip that row
                for(int col = 0; col < noCols; col++) {
                    grid[row][col] = 1 - grid[row][col]; //flipping
                }
            }
        }
        
        //traverse through col = 1 to noCols and if countZeros > countOnes --> flip that col
        for(int col = 1; col < noCols; col++) {
            
            int countZero = 0;
            for(int row = 0; row < noRows; row++) {
                if(grid[row][col] == 0)
                    countZero++;
            }
            
            int countOne = noRows - countZero;
            if(countZero > countOne) {
                //flip that col
                for(int row = 0; row < noRows; row++) {
                    grid[row][col] = 1 - grid[row][col];
                }
            }
        }
        
        int score = 0;
        for(int row = 0; row < noRows; row++) {
            for(int col = 0; col < noCols; col++) {
                int value = grid[row][col] * (1 << noCols - col - 1);  //(1 << noCols - col - 1) -> place value --> pwoer(2, noCols - col - 1)
                score += value;
            }
        }
        
        return score; 
        
    }
}

/*
TC - O(noRows * noCols)
SC - O(1)
*/