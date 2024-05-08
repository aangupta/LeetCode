class Pair {
    int score;
    int index;
    Pair(int score, int index) {
        score = this.score;
        index = this.index;
    }
}

class Solution {
    public String[] findRelativeRanks(int[] scores) {
        String[] result = new String[scores.length];
        
        PriorityQueue<int[]> pq =new PriorityQueue<>((x, y) -> y[0]-x[0]);
        
        for(int i = 0; i < scores.length; i++) {
            int[] pair = new int[]{scores[i], i};
            pq.add(pair);
    
        }
        
        
        int count = 0;
        while(pq.size() > 0) {
            int[] temp = pq.peek();
            pq.poll();
            int index = temp[1];
            int score = temp[0];
            count++;
            
            if(count <= 3) {
                if(count == 1)
                  result[index] = "Gold Medal";
                if(count == 2)
                    result[index] = "Silver Medal";
                if(count == 3)
                    result[index] = "Bronze Medal";
            }
            else {
                result[index] = Integer.toString(count);
            }
        }
        return result;
    }
}