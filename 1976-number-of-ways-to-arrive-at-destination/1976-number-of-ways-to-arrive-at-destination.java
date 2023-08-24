/* Point too be noted:
++ if constraints are high like 10^9, consider using long/double and while returing answer type cast it
++ PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (int)(a.dist - b.dist)); in pq if the value to be comapred is other than int .. we need to type cast it
*/

class Pair { 
    int node;
    long dist;
    Pair(int node,   long  dist) {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        
        //creating adjacency list
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++){
            adjList.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adjList.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        
        //
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (int)(a.dist - b.dist));
        long[] distance = new long[n];
        int[] ways = new int[n];
        
        for(int i = 0; i < n; i++) {
            distance[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        
        distance[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0,0));
        
        int mod = (int)(1e9 + 7);
        
        while(pq.size() > 0) {
            
            int currNode = pq.peek().node;
            long currDist = pq.peek().dist;
            
            pq.remove();
            
            for(int i = 0; i < adjList.get(currNode).size(); i++){
                int adjNode = adjList.get(currNode).get(i).node;
                long edgeW = adjList.get(currNode).get(i).dist;
                
                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the no. of ways the same.
                if(currDist + edgeW < distance[adjNode]){
                    distance[adjNode] = currDist + edgeW;
                    pq.add(new Pair(adjNode, distance[adjNode]));
                    ways[adjNode] = ways[currNode] % mod;
                }
                // If we again encounter a node with the same short distance
                // as before, we simply increment the no. of ways
                else if( currDist + edgeW == distance[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[currNode]) %mod;
                }
            }
            
        }
        
        return ways[n-1]%mod;
    }
}

//O( E* log(V)) { As we are using simple Dijkstra’s algorithm here, the time complexity will be or the order E*log(V)}

