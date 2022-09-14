class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); 
        
        for(int i = 0; i < stones.length; i++){
            maxPQ.add(stones[i]);
        }
        
        while(maxPQ.size() > 1){
            
            int y = maxPQ.poll();
            int x = maxPQ.poll();
            
            if(x != y){
                maxPQ.add(y-x);
            }
        }
        
        return (maxPQ.size() == 1) ? maxPQ.peek() : 0;
        
    }
}

Put all elements into a priority queue.
Pop out the two biggest, push back the difference,
until there are no more two elements left.


Complexity
Time O(NlogN)
Space O(N)
