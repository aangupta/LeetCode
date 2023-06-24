class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand == null || hand.length == 0) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Card> minPQ = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minPQ.offer(new Card(entry.getKey(), entry.getValue()));
        }
        
        while(minPQ.size() > 0){
            int k = groupSize;
            Set<Card> tempSet = new HashSet<>();
            int currVal = -1;
            
            while(k > 0 && minPQ.size() > 0){
                Card card = minPQ.poll();
                
                if(currVal == -1){
                    currVal = card.val;
                } else {
                    if(currVal + 1 != card.val) return false;
                    else  currVal = card.val;
                }
                
                if(card.count > 1){
                    card.count--;
                    tempSet.add(card);
                }
                k--;
            }
            
            if(minPQ.size() == 0 && k > 0) return false;
            
            minPQ.addAll(tempSet);
            
        }
        
        return true;
        
        
        
    }
}

class Card {
    int val;
    int count;
    
    Card(int val, int count){
        this.val = val;
        this.count = count;
    }
}