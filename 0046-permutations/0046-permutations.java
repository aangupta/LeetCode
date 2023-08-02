class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        permuteUtils(nums, new ArrayList<>(), result);
        
        return result;
    }
    
    private void permuteUtils(int[] nums, List<Integer> tempList,  List<List<Integer>> result) {
        
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            
            if(tempList.contains(nums[i])) continue;
            
            tempList.add(nums[i]);
            permuteUtils(nums,tempList,result);
            tempList.remove(tempList.size() - 1);
        }
    }
}