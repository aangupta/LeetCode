class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while( i < m && j < n){
            if(nums1[i] <= nums2[j]){
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        
        if(i != m){
            while(i < m){
                list.add(nums1[i]);
                i++;
            }
        }
        
        if(j != n){
            while(j < n){
                list.add(nums2[j]);
                j++;
            }
        }
        
        for(int k = 0; k < m+ n; k++){
            nums1[k] = list.get(k);
        }
    }
}