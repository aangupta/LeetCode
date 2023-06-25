class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b) -> (a.count - b.count));
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            
            pq.offer(new Element(entry.getKey(), entry.getValue()));
            
            if(pq.size() > k) 
                pq.poll();
        }
        
        int[] res = new int[k];
        int i = 0;
        
        while(pq.size() > 0){
            res[i++] = pq.poll().value;
        }
        
        return res;
        
        
        
    }
}

class Element {
    int value;
    int count;
    
    Element(int value, int count){
        this.value = value;
        this.count = count;
    }
}