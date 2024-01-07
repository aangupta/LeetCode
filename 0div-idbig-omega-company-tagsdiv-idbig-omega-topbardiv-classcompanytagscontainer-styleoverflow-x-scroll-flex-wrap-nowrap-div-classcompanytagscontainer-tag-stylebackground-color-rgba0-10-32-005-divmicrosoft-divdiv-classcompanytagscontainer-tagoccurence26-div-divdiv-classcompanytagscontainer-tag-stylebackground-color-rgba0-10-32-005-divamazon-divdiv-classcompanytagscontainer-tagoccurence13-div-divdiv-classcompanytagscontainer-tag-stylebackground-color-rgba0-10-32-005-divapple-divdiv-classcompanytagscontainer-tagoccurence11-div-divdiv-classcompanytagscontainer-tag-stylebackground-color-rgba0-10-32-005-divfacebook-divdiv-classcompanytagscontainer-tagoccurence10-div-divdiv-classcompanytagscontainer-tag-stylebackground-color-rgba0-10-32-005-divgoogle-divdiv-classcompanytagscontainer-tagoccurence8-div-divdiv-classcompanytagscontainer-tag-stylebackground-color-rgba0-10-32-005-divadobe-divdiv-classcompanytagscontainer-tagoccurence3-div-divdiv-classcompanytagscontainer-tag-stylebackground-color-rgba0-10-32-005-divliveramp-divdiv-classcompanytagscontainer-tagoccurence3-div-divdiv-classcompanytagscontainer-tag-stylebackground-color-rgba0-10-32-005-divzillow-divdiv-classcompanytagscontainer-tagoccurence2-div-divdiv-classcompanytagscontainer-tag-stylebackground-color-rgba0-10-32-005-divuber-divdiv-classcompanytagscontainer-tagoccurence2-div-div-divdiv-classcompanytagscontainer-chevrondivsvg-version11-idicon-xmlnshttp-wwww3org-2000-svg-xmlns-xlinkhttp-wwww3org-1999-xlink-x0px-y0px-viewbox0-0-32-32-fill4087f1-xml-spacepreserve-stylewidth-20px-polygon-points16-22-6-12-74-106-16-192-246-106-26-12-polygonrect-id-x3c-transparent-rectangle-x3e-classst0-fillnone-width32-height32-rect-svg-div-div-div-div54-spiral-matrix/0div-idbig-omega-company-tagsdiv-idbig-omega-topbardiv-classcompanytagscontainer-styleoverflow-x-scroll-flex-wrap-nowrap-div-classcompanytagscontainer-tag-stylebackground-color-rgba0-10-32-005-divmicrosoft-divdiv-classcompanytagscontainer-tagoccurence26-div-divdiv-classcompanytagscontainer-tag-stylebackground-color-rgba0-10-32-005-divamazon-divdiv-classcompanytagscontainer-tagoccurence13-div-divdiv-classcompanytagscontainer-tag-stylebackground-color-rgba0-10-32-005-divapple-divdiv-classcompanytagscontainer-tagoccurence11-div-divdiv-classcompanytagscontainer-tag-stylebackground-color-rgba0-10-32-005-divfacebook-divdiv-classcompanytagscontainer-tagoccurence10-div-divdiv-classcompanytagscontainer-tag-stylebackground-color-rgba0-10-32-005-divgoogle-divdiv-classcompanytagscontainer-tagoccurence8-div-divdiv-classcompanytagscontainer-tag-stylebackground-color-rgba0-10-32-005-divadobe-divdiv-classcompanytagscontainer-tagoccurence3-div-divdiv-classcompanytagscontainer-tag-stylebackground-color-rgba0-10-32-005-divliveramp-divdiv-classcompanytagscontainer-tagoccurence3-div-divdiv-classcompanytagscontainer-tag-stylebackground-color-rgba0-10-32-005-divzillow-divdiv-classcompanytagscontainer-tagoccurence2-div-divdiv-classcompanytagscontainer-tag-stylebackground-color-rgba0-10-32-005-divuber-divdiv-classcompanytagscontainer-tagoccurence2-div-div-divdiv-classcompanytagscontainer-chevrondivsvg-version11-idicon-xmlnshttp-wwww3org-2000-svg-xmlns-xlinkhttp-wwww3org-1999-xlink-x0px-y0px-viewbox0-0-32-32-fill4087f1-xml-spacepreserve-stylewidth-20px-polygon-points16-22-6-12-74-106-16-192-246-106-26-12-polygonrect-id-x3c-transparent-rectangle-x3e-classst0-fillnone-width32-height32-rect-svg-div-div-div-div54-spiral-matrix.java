class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int top = 0, left = 0, bottom = n-1, right = m-1;
        
        while(top <= bottom && left <= right) {
            
            //go right
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            
           if(top > bottom) break;
            
            //go down
            for(int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            
            right--;
            
            if(right < left) break;
            
            //go left
            for(int i = right; i >= left; i--) {
                 res.add(matrix[bottom][i]);
            }
            
            bottom--;
            
            if(bottom < top) break;
            
            //go up
            for(int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            
            if(left > right) break;
            
        }
        return res;
        
    }
}