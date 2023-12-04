class Solution {
    /* Recursion */
    private void helper(int ind, int[] nums, List<List<Integer>> res, List<Integer> curr) {
        
        //base case
        if(ind == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        //including element at current index
        curr.add(nums[ind]);
        helper(ind + 1, nums, res, curr);
        curr.remove(curr.size()-1);
        
        //excluding element at current index
        helper(ind+1, nums, res, curr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        helper(0, nums, res, curr);
        
        return res;
        
    }
}