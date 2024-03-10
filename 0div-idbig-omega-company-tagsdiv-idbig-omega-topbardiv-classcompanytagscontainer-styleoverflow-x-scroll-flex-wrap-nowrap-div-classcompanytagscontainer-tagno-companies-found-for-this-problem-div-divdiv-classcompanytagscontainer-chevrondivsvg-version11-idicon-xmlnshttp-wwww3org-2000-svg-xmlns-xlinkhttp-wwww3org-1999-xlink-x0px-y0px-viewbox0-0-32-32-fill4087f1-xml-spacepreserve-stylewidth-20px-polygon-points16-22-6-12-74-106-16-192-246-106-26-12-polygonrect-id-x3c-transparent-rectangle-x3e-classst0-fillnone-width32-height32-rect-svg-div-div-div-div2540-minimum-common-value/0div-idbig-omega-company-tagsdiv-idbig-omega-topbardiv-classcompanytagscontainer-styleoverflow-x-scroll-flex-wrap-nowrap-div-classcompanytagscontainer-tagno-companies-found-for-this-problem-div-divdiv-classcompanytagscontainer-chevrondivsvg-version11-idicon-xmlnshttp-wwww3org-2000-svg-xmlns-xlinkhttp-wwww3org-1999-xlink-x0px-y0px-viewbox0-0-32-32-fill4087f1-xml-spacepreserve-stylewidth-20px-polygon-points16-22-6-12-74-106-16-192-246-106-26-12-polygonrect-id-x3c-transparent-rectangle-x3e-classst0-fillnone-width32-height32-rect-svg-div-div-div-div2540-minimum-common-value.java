class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = nums1.length-1, j = nums2.length-1;
        
        int smallestElement = -1;
        
        while(i >= 0 && j >= 0) {
            if(nums1[i] == nums2[j]){
                smallestElement = nums1[i];
                i--;
                j--;
            }
            else if(nums1[i] > nums2[j])
                i--;
            else 
                j--;
        }
        
        return smallestElement;
        
    }
}