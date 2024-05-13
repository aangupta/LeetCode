class Solution {
    // Solution 2 without modifying the input array
    public int matrixScore(int[][] grid) {
        int noRows = grid.length;
        int noCols = grid[0].length;
        
        int score = 0;
        
        //to get the max number, the msb of each binary number(represented by each row) should be one
        //here we are assuming col 0 -> all the values are 1
        
        //MSB -> 2^noCols-1
        score = noRows * (1 << noCols -1);
        
        //now we need to check the rest of the cols
        
        for(int col = 1; col < noCols; col++) {
            int countSameBits = 0; //no of 1s
            for(int row = 0; row < noRows; row++) {
                if(grid[row][0] == grid[row][col])   //tricky part
                    countSameBits++;
            }
            int countOnes = countSameBits;
            int countZeros = noRows - countOnes;
            
            int ones = Math.max(countOnes, countZeros);
            
            score += (1 << noCols - col - 1) * ones;
            
        }
        
        
        return score; 
        
    }
}

/*
TC - O(noRows * noCols)
SC - O(1)
*/