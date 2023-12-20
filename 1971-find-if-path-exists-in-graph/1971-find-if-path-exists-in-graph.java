class Solution {
    // adjacency list + dfs
    //TC 0(V+E) 
    
    private boolean dfs(int n, ArrayList<ArrayList<Integer>> adjList, int source, int destination, int[] visited) {
        
        visited[source] = 1;
        
        if(source == destination) return true;
        
        for(int neighbour : adjList.get(source)) {
            if(visited[neighbour] == 0 && dfs(n,adjList, neighbour, destination, visited))
                return true;
        }
        
        return false;
        
    }
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
        
        return dfs(n, adjList, source, destination, visited);
    }
}