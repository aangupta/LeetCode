class Solution {
    
    private boolean dfsCheck(int node,int[][] graph, int[] visited, int[] pathVisited,  int[] check) {
        int rows = graph.length;
        int cols = graph[0].length;
        
        visited[node] = 1;
        pathVisited[node] = 1;
        check[node] = 0;
        
        for(int i = 0; i < graph[node].length; i++){
            
            int neighbour = graph[node][i];
            //System.out.println(node + " " + neighbour);
            
            if(visited[neighbour] == 0){
                if(dfsCheck(neighbour, graph, visited, pathVisited, check) == true){
                    check[neighbour] = 0;
                    return true;
                } 
            }
            else if(pathVisited[neighbour] == 1){
                    check[neighbour] = 0;
                    return true;
            }
        }
        
        pathVisited[node] = 0;
        check[node] = 1;
        
        return false;
        
        
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int rows = graph.length;
        int cols = graph[0].length;
        
        int[] visited = new int[rows];
        int[] pathVisited = new int[rows];
        int[] check = new int[rows];
        
        for(int i = 0; i < rows; i++){
            if(visited[i] == 0){
                dfsCheck(i, graph, visited, pathVisited, check);
            }
        }
        
        List<Integer> result = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            if(check[i] == 1) result.add(i);
        }
        
        return result;
        
        
    }
}