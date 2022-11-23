class Solution {
    
    private int solve(ArrayList<Integer> arr){
        
        int n = arr.size();
        int prev = arr.get(0);
        int prev2 = 0;
        
        for(int i = 1; i < n; i++){
            int pick = arr.get(i);
            
            if(i > 1)
                pick += prev2;
            
            int notPick = prev;
            
            int curri = Math.max(pick, notPick);
            
            prev2 = prev;
            prev = curri;
        }
        
        return prev;
        
        
    }
    public int rob(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            
            if(i != 0) arr1.add(nums[i]);
            if(i != nums.length-1) arr2.add(nums[i]);
        }
        
        return Math.max(solve(arr1), solve(arr2));
        
    }
}

/*The approach to solving this problem can be summarized as:

Make two reduced arrays – arr1(arr-last element) and arr2(arr-first element).
Find the maximum of non-adjacent elements as mentioned in article DP5 on arr1 and arr2 separately. Let’s call the answers we got as ans1 and ans2 respectively.
Return max(ans1, ans2) as our final answer */