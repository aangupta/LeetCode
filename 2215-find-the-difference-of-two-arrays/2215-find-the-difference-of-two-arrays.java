class Solution {
    
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        result.add(findUnique(nums1, nums2));
        result.add(findUnique(nums2, nums1));
        
        return result;
        
    }
    
    private List<Integer> findUnique(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums1){
            if(map.containsKey(num) == false){
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        
        for(int num : nums2){
            if(map.containsKey(num) == true){
                map.put(num, 0);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> element : map.entrySet()){
            if(element.getValue() != 0){
                ans.add(element.getKey());
            }
        }
        
        return ans;
        
        
    }
}