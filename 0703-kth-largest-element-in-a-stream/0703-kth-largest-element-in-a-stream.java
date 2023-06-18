class KthLargest {

    int k;
    PriorityQueue<Integer> minPQ;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minPQ = new PriorityQueue<>();
        
        for(int num : nums){
            minPQ.offer(num);
            if(minPQ.size() > k)
                minPQ.poll();
        }
      
        
    }
    
    public int add(int val) {
        minPQ.offer(val);
        
        if(minPQ.size() > k) minPQ.poll();
        
        return minPQ.peek();
        
    }
    

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */