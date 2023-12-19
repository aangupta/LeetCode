class Solution {
    // adjacency list + bfs
    //TC 0(V+E) 
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        //creating adjList from the given edges array
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        
        int[] visited = new int[n];
        
        Queue<Integer> queue = new LinkedList<>();
        
        //adding the source node to queue and marking it visited
        queue.add(source);
        visited[source] = 1;
        
        while(queue.size() > 0) {
            
            int currNode = queue.peek();
            queue.remove();
            
              if(currNode == destination) return true;
            
            //checking all the adj nodes of the current node, if not visited mark it visited and add it to queue
            for(int adjNode : adjList.get(currNode)) {
                if(visited[adjNode] == 0) {
                    visited[adjNode] = 1;
                    queue.add(adjNode);
                }
            }
        }
        
       
        return false;
        
    }
}