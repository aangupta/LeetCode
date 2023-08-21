class Pair {
    int node;
    int time;
    
    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < times.length; i++) {
            adjList.get(times[i][0]).add(new Pair(times[i][1] , times[i][2]));
        }
        
        int[] distance = new int[n+1];
        for(int i = 0; i <= n; i++){
           distance[i] = (int)1e9;
        }
        
        int time = 0;
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(k,0));
        distance[k] = 0;
        
        while(queue.size() > 0) {
            Pair iter = queue.peek();
            queue.remove();
            int node = iter.node;
            int cost = iter.time;
            
            for(int i = 0; i < adjList.get(node).size(); i++) {
                Pair it = adjList.get(node).get(i);
                int adjNode = it.node;
                int edgeW = it.time;
                
                if(edgeW + cost < distance[adjNode]) {
                    distance[adjNode] = edgeW + cost;
                    queue.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(distance[i] == 1e9) {
                return -1;
            }
        }
        
        int maxTime = 0;
        
        for(int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, distance[i]);
        }
        
        return maxTime;
        
    }
}