class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] players = new int[n][2];
        
        //o(nlogn)
        for(int i = 0; i < n; i++){
            players[i][0] = efficiency[i];
            players[i][1] = speed[i];
        }
        
        //Sort the players based on efficiency in decreasing order, as for each iteration, we'll consider only players with higher efficiency.
        Arrays.sort(players, (p1, p2) -> (p2[0] - p1[0]));
        
        //To keep track of players with highest relative speeds with efficiencies 
        PriorityQueue<Integer> speedQueue = new PriorityQueue<>(k);
        
        long maxPerformance = 0, teamSpeed = 0;
        
        //As we already sorted the players list in the decreasing order, with each iteration we only need to pick all the players(k) which maximise the overall team speed
    
        //O(nlogk)
        for (int i = 0; i < n; i++){
            
            if(speedQueue.size() == k){
                teamSpeed -= speedQueue.remove();
            }
            
            speedQueue.add(players[i][1]);
            teamSpeed += players[i][1];
            
            maxPerformance = Math.max(maxPerformance, teamSpeed * players[i][0]);
        }
        
        return (int) (maxPerformance % 1000000007);
    }
    
    //TC O(nlogn) -> Sorting + O(nlogk)
}