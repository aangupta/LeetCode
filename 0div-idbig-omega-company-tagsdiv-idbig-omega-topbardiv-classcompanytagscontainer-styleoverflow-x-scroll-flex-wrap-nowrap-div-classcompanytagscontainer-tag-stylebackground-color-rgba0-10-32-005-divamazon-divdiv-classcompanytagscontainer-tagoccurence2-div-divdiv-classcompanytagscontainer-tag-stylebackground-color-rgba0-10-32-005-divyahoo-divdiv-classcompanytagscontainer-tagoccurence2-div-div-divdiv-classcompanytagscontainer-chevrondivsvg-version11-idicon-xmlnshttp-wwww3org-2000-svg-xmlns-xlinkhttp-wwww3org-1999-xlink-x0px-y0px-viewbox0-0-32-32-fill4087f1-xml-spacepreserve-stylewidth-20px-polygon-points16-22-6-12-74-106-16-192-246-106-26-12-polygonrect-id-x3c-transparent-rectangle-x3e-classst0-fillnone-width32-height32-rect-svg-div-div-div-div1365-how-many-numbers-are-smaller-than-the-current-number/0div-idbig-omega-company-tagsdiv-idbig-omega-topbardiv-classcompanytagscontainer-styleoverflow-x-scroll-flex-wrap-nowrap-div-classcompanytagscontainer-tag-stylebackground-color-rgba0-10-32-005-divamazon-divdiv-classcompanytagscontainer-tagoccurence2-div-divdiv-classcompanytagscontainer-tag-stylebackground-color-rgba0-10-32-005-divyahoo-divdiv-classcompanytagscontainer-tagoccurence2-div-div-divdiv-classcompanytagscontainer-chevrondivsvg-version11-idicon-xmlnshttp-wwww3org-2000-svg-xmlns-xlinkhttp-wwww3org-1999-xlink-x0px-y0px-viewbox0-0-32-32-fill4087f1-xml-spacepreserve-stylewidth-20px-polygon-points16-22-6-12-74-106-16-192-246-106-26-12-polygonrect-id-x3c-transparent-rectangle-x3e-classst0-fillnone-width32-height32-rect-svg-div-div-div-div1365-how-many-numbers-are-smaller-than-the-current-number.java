class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(nums[i] == copy[j]) {
                    res[index] = j;
                    index++;
                    break;
                }
            }
        }
        
        return res;
    }
}