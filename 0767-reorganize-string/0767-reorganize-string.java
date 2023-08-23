class Letter {
    char ch;
    int count;
    
    Letter(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}
class Solution {
    public String reorganizeString(String s) {
        
        if(s == null || s.length() == 0) return "";
        
        Map<Character, Letter> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            map.putIfAbsent(c, new Letter(c, 0));
            map.get(c).count += 1;
            
            if(map.get(c).count > (s.length() + 1)/2) return ""; 
        }
        
        PriorityQueue<Letter> maxPQ = new PriorityQueue<>((a,b) -> b.count - a.count);
        maxPQ.addAll(map.values());
        
        StringBuilder sb = new StringBuilder();
        
        while(maxPQ.size() > 0){
            int k = 2;
            Queue<Letter> buffer = new LinkedList<>();
            
            while(k > 0 && maxPQ.size() > 0){
                Letter letter = maxPQ.poll();
                sb.append(letter.ch);
                
                letter.count = letter.count - 1;
                
                if(letter.count > 0) buffer.add(letter);
                
                k--;
            }
            
            maxPQ.addAll(buffer);
        }
        
        return (sb.length() == s.length() ? sb.toString() : " ");
        
        
    }
}