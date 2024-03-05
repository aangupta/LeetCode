class Solution {
    private void subsetsUtils(int[] nums, int index,List<Integer> curr, List<List<Integer>> res ) {
        
        //base case
        if(index == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        //including the element
        curr.add(nums[index]);
        subsetsUtils(nums, index + 1, curr, res);
        curr.remove(curr.size()-1);
        
        //excluding the element
        subsetsUtils(nums, index + 1, curr, res);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        subsetsUtils(nums, 0, curr, res);
        return res;
    }
}

//TC O(2^n) SC O(n)