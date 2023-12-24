class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        
        //discarding 0 as integers should not have leading zeros
        for(int i = 1; i <=9 ; i++) {
           queue.add(new int[]{i,1});
        }
        
        
        while(queue.size() > 0) {
            int[] val = queue.peek();
            queue.remove();
            
            int num = val[0];
            int len = val[1];
            
            if(len == n){
                res.add(num);
                continue;
            }
            
            int lastDigit = num % 10;
            
            if(lastDigit + k <= 9) 
                queue.add(new int[]{10 * num +lastDigit + k, len + 1});
            
            if(k != 0 && lastDigit - k >= 0)
                 queue.add(new int[]{10 * num +lastDigit - k, len + 1});
            
        }
        
        int[] nums = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            nums[i] = res.get(i);
        }
        
        return nums;
    }
}