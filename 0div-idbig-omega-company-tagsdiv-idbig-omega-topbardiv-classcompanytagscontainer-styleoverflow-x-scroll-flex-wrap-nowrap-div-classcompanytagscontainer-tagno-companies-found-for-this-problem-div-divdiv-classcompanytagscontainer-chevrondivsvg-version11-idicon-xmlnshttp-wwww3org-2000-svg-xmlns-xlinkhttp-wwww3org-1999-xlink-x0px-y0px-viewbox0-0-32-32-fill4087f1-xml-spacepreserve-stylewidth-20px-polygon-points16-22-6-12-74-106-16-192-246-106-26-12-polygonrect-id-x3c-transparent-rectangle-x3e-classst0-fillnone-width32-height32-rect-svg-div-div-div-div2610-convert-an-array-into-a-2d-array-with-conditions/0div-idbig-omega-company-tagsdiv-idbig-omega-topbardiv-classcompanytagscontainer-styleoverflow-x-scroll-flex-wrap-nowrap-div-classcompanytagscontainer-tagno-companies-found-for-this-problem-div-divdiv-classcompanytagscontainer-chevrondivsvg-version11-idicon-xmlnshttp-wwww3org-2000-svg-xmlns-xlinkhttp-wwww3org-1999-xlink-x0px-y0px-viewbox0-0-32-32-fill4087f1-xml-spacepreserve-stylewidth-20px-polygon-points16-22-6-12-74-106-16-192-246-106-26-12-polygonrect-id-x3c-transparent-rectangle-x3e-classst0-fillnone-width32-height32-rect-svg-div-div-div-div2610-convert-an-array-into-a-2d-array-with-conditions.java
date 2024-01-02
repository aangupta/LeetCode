class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int num : nums) {
            if(freq[num] >= res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(freq[num]).add(num);
            freq[num]++;
        }
        
        return res;
        
       
        
    }
}