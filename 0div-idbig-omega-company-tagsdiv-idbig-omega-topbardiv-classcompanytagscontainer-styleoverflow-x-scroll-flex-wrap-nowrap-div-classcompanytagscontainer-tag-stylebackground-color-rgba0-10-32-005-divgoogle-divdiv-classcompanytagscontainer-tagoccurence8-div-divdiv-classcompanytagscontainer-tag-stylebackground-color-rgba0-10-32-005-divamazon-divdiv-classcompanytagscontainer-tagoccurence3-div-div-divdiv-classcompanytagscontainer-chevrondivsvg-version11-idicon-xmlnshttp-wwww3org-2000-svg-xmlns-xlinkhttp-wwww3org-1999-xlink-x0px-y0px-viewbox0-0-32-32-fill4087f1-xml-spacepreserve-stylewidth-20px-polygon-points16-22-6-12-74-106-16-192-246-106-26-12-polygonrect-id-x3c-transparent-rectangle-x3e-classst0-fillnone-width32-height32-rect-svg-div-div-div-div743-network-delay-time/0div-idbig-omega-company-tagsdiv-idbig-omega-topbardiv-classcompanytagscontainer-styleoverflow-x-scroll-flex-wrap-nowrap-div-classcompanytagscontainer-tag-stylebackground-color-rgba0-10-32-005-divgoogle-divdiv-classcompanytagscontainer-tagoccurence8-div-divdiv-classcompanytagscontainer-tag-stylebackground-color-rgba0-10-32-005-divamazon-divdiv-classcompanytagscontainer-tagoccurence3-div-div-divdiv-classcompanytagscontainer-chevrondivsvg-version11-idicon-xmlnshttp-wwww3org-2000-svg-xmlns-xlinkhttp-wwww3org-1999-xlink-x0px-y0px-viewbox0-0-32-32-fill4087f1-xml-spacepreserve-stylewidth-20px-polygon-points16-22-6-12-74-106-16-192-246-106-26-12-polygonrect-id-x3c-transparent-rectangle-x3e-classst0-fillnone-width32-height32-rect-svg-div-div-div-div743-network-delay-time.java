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
        
        for(int i = 0; i <=n; i++) {
           adjList.add(new ArrayList<>());
        }
        
        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adjList.get(u).add(new Pair(v,t));
        }
        
        //vertex starting from index 1
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.time - y.time);
        pq.add(new Pair(k, 0));
        distance[k] = 0;
        
        while(pq.size() > 0) {
            Pair it = pq.poll();
            int node = it.node;
            int time = it.time; // time required to reach the node from the source node
            
            for(Pair neighbor : adjList.get(node)) {
                int adjNode = neighbor.node;
                int edgeW = neighbor.time;
                
                if(distance[adjNode] > distance[node] + edgeW) {
                    distance[adjNode] = distance[node] + edgeW;
                    pq.add(new Pair(adjNode,distance[adjNode]) );
                }
            }
        }
        
        //any node with distnace value Integer.MAX_VALUE, that means that node is nkot reachable from the given src
        for(int i = 1; i <= n; i++) {
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
        }
        //max time to reach all the nodes
        int maxTime = -1;
        for(int i = 1; i <= n; i++){
            maxTime = Math.max(distance[i], maxTime);
        }
        
        return maxTime;
    }

}