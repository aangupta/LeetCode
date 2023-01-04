class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int task : tasks){
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        
        int minRounds = 0;
        
        for(int it : freq.values()) {
            
            if(it == 1) return -1;
            
            minRounds  += it/3;
            
            if(it%3 != 0)
                minRounds++;    
        }
        
        return minRounds;    
    }
}

//TC O(N) SC O(N)

/*If x%3==0, ans = x/3;
if x%3==1, ans=1+(x/3);
if x%3==2, ans = 1+ (x/3); 


If freq = 1, not possible, return -1
If freq = 2, needs one 2-tasks
If freq = 3, needs one 3-tasks
If freq = 3k, freq = 3 * k, needs k batchs.
If freq = 3k + 1, freq = 3 * (k - 1) + 2 + 2, needs k + 1 batchs.
If freq = 3k + 2, freq = 3 * k + 2, needs k + 1 batchs.*/

