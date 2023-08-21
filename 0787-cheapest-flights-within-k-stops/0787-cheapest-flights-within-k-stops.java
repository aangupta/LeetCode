class Pair { 
    int node;
    int price;
    Pair(int node, int price) {
        this.node = node;
        this.price = price;
    }
}

class Tuple {
    int node;
    int stop;
    int price;
    
    Tuple(int node, int stop, int price) {
        this.node = node;
        this.stop = stop;
        this.price = price;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        //creating adjacency list
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i =0; i < flights.length; i++) {
            adjList.get(flights[i][0]).add(new Pair(flights[i][1] , flights[i][2]));
        }
        
        int[] distance = new int[n];
        
        for(int i = 0; i < n; i++){
            distance[i] = (int)1e9;
        }
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.stop - b.stop);
        pq.add(new Tuple(src, 0, 0));
        
        distance[src] = 0;
        
        while(pq.size() > 0) {
            Tuple it = pq.peek();
            pq.remove();
            int currNode = it.node;
            int stops = it.stop;
            int cost = it.price;
            
            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue;
            
            for(int i = 0; i < adjList.get(currNode).size(); i++){
                Pair iter = adjList.get(currNode).get(i);
                int adjNode = iter.node;
                int edgeW = iter.price;
                
                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if(cost + edgeW < distance[adjNode] && stops <= k) {
                    distance[adjNode] = cost + edgeW;
                    pq.add(new Tuple(adjNode, stops + 1, distance[adjNode]));
                }
            }
        }
        
        return (distance[dst] == 1e9 ? -1 : distance[dst]);
        
        
        
        
    }
}