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