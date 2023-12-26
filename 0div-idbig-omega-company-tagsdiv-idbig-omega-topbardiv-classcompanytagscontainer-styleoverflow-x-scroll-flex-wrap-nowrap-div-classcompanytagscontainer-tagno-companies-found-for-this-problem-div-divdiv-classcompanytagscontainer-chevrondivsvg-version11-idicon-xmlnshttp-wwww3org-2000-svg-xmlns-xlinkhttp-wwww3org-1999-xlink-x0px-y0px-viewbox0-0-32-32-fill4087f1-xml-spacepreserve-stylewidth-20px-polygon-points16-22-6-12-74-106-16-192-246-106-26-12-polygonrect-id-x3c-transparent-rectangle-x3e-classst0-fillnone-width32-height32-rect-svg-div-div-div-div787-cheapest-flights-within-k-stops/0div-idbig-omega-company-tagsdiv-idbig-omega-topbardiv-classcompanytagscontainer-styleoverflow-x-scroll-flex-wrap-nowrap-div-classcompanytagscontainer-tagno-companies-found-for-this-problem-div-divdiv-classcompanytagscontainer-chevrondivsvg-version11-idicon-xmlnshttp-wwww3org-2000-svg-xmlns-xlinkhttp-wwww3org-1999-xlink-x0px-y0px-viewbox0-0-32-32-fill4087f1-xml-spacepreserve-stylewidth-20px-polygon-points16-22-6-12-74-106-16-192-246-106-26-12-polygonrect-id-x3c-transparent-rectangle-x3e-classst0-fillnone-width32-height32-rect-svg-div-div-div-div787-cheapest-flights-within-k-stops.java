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
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.stop - b.stop);
        pq.add(new Tuple(src, 0, 0));
        distance[src] = 0;
        
        while(pq.size() > 0) {
            int node = pq.peek().node;
            int stops = pq.peek().stop;
            int price = pq.peek().price;
            pq.remove();
            
            // We stop the process as soon as the limit for the stops is reached.
            if(stops > k) continue;
            
            for(Pair neighbor : adjList.get(node)) {
                int adjNode = neighbor.node;
                int edgeW = neighbor.price;
                
                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if(distance[adjNode] > price + edgeW && stops <= k){
                    distance[adjNode] = price + edgeW;
                    pq.add(new Tuple(adjNode, stops + 1, distance[adjNode]));
                }
            }
        }
        
        return (distance[dst] == Integer.MAX_VALUE? -1 : distance[dst]);

        
    }
}