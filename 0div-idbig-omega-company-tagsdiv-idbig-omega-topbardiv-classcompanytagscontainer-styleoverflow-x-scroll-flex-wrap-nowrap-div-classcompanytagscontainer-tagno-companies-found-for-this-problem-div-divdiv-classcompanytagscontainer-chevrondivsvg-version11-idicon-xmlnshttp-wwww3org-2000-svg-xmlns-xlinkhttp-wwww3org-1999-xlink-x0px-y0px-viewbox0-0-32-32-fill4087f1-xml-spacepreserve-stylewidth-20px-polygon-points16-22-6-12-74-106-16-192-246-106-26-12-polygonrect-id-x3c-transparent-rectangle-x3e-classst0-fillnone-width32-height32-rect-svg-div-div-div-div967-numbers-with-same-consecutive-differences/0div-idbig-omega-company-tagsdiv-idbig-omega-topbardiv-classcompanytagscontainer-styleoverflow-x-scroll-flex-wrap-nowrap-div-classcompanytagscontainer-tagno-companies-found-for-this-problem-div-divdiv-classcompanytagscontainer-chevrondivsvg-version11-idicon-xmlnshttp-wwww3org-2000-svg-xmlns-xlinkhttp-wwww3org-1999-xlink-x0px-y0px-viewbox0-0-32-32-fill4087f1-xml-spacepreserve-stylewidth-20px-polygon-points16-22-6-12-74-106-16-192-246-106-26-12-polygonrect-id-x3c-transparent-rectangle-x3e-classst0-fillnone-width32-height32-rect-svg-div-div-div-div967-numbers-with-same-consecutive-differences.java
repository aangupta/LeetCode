class Solution {
    private void dfs(int currNum, int n, int k, List<Integer> res ) {
        if(n == 0) {
            res.add(currNum);
            return;
        }
        
        int lastDigit = currNum % 10;
        
         //if k == 0, we will be having duplicate numbers from both the dfs calls, so need to discard one dfs call
        if(lastDigit + k <= 9)
            dfs(currNum * 10 +lastDigit + k, n-1, k, res);
       
        if(k != 0 && lastDigit - k >= 0)
            dfs(currNum * 10 +lastDigit - k, n-1, k, res);
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        
        //discarding 0 as integers should not have leading zeros
        for(int i = 1; i <=9 ; i++) {
            dfs(i, n-1, k, res);
        }
        
        int[] nums = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            nums[i] = res.get(i);
        }
        
        return nums;
    }
}