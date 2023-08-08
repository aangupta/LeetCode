class Solution {
    
    private void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v){
        
        adjList.get(u).add(v);
        adjList.get(v).add(u);
        
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        if(n == 1) return true;
        
        if(source == destination) return true;
        
        //creating adjList from the given edges array
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            addEdge(adjList, edges[i][0], edges[i][1]);
        }
        
        
        int[] visited = new int[n];
        
        Queue<Integer> queue = new LinkedList<>();
        
        //adding the source node to queue and marking it visited
        queue.add(source);
        visited[source] = 1;
        
        while(queue.size() > 0) {
            
            int currNode = queue.peek();
            queue.remove();
            
            //checking all the adj nodes of the current node, if not visited mark it visited and add it to queue
            for(int adjNode : adjList.get(currNode)) {
                
                if(visited[adjNode] == 0) {
                    
                    if(adjNode == destination) return true;
                    
                    visited[adjNode] = 1;
                    queue.add(adjNode);
                }
            }
        }
        
       
        return false;
        
    }
}