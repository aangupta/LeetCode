class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        
        queue.offer(0);
        
        for(int i = 1; i < nums.length; i++){
            
            while(queue.size() > 0 && queue.peek() < i - k){
                queue.poll();
            }
            
            nums[i] = nums[i] + nums[queue.peekFirst()];
            
            while(queue.size() > 0 && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            
            queue.offer(i);
        }
        
        return nums[nums.length - 1];
        
    }
}