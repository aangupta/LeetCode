/** 
 ++ Using the approach of Next Greater Element
 ++ Using Deque - Storing element(indexes) in decreasing fashion
 ++ Before pushing the current element into the queue
    remove the indexes which are out of bound [indexes doesn't resides in current window from the front of the queue]
    from the rear end delete all the indexs whos value is less than the current element
    add the current element into the queue.
 ++ we know index staring from [k-1 ... n-1] are the ending point of the current sliding window of size k, so add the queue front index will be the max element, so store this to the result array.
    
    TC - O(N) + O(N)  
    SC - O(N) - at max we can have k elements in our queue.
**/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums.length == 0) return new int[]{};
        
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        
        //storing the indexes - (decreasing fashion)
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < nums.length; i++){
            
            //checking for out of bound indexes, only have element indexes of current window size
            if(queue.size() > 0 && queue.peek() == i - k){
                queue.poll();
            }
            
            //removing all the elements smaller than the current element from the rear end 
            //as these elements will not help in find max element in current window
            while(queue.size() > 0 && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            
            //adding the current element index  after performing the sanitization
            queue.offer(i);
            
            //here we now that from k-1 to n-1 are the ending indexes of the sliding window of size k
            if(i >= k-1){
                result[index++] = nums[queue.peek()];
            }
            
        }
        
        return result;
        
    }
}