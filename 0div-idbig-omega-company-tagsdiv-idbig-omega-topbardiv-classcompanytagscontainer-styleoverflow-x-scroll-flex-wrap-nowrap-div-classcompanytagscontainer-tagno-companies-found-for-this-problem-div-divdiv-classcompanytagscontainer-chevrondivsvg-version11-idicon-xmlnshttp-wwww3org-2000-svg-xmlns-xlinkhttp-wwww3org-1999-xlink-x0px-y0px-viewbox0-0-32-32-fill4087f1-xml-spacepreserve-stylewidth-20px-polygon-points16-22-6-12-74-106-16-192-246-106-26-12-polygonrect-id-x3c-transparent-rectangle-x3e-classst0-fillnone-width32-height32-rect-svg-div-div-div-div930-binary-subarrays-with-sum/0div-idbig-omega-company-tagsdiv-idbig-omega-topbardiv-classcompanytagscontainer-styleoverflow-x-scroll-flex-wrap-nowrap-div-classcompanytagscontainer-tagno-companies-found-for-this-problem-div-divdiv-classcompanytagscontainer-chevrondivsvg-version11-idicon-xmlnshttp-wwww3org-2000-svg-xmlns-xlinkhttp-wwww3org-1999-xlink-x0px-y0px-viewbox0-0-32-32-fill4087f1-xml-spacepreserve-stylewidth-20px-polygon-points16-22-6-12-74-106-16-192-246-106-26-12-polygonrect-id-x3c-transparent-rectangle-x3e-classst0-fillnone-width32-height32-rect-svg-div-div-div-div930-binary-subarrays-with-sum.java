class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        
        //map<cumulativeSum, count>
        Map<Integer, Integer> map = new HashMap<>();
        int cumulativeSum = 0;
        
        map.put(0, 1);   //imp step
        
        for(int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            
            if(map.containsKey(cumulativeSum - goal) == true) {
                count += map.get(cumulativeSum - goal);
            }
            
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
            
        }
        
        return count;
    }
}

//TC - O(nlogn(n))
//Sc - O(n)