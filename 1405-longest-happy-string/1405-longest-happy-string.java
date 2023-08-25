class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder("zz");
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[1] - x[1]);
        
        if(a > 0)
        pq.add(new int[]{0,a});
        
        if(b > 0)
        pq.add(new int[]{1,b});
        
        if(c > 0)
        pq.add(new int[]{2,c});
        
        while(pq.size() > 0) {
            int[] temp = new int[] {-1,-1};
            char peekChar = (char) ('a' + pq.peek()[0]);
            
           if(peekChar == sb.charAt(sb.length()-1) && peekChar == sb.charAt(sb.length()-2)) {
               temp[0] = pq.peek()[0];
               temp[1] = pq.peek()[1];
               pq.poll();
               
               if(pq.size() == 0) break;
           }
            
            peekChar = (char) ('a' + pq.peek()[0]);
            
            if(peekChar != sb.charAt(sb.length()-1) ||  peekChar != sb.charAt(sb.length()-2)) {
                int[] removed = pq.poll();
                sb.append(peekChar);
                removed[1]--;
                
                if(removed[1] > 0) pq.add(removed);
            }
            
            if(temp[0] != -1){
                pq.add(temp);
            }   
        }
        
        return sb.substring(2).toString();
    }
}