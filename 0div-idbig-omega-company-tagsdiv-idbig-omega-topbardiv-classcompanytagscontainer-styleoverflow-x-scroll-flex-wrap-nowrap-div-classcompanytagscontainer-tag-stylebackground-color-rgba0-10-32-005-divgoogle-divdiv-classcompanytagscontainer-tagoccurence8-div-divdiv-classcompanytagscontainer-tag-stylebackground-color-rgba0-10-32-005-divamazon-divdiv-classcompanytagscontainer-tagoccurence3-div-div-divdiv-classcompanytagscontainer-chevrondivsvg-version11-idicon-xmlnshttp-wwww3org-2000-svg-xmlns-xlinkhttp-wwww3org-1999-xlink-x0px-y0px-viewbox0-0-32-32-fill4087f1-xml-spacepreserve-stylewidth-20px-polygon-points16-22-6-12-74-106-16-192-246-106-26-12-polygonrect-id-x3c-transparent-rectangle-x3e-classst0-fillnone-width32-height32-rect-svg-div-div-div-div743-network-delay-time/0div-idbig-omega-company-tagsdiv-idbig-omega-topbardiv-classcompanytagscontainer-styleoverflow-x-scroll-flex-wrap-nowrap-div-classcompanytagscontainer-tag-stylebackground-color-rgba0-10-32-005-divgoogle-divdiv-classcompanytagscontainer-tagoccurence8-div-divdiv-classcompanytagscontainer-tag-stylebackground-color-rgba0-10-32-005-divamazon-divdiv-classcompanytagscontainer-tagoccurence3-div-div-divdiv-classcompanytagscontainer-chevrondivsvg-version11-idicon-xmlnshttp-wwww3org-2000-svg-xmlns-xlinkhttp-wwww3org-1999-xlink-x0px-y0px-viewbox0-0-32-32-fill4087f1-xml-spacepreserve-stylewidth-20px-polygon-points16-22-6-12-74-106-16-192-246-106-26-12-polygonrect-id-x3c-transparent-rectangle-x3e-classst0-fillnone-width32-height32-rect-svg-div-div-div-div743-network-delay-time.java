class Solution {
    //bellman-ford
    public int networkDelayTime(int[][] times, int n, int k) {
        //stores the shortest distnace of all nodes from the given src
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[k] = 0; 
        
        //relaxing all the edges (n - 1) times
        for(int i = 1; i <= n; i++) {
            for(int[] time : times) {
                int u = time[0];
                int v = time[1];
                int t = time[2];
                
                if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + t) {
                    distance[v] = distance[u] + t;  //relaxation
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(distance[i] == Integer.MAX_VALUE)
                return -1;
        }
        
        int maxTime = -1;
        for(int i = 1; i <= n; i++) {
           maxTime = Math.max(maxTime, distance[i]);
        }
        
        return maxTime;
        
        
    }
}