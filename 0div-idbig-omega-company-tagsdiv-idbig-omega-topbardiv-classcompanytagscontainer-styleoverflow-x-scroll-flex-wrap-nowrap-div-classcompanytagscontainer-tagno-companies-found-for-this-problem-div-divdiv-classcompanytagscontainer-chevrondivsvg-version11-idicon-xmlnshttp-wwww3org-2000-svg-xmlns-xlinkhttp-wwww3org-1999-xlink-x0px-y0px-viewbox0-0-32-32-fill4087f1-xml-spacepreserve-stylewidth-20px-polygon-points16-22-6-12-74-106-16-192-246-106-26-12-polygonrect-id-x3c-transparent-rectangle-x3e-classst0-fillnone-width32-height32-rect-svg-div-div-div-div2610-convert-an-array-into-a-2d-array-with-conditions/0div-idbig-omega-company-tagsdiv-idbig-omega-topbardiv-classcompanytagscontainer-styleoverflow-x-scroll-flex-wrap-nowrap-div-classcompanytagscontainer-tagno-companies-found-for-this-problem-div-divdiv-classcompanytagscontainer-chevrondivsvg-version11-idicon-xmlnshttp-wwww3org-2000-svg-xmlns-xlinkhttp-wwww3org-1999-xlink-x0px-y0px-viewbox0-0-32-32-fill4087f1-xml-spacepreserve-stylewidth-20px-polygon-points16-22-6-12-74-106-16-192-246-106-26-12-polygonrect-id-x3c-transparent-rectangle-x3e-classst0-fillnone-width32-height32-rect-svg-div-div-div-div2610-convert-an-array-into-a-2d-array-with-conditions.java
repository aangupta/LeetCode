class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];
        Arrays.fill(freq, 0);
        
        for(int num : nums) {
            freq[num]++;
        }
        
        List<List<Integer>> res = new ArrayList<>();
        int count = n;
        
        while(count > 0) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 1; i <= n; i++) {
                if(freq[i] > 0) {
                    temp.add(i);
                    freq[i]--;
                    count--;
                }
            }
            res.add(temp);
        }
        return res;
        
    }
}