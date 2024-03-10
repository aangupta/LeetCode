class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        
        for(int i = 0; i < nums1.length; i++) {
            freq[nums1[i]]++;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < nums2.length; i++) {
            if(freq[nums2[i]] >= 1){
                res.add(nums2[i]);
                freq[nums2[i]] = 0;
            }    
        }
        
        int[] uniqueElements = new int[res.size()];
        int i = 0;
        for(int num : res){
            uniqueElements[i] = num;
            i++;
        }
        
        return uniqueElements;
    }
}