class Solution {
    
    private boolean isBipartite(int start, int[][] graph, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        
        while(queue.size() > 0){
            int node = queue.peek();
            queue.remove();
            
            for(int i = 0; i < graph[node].length; i++){
                
                //if adjacent node is not yet color, 
                //we need to give opposite color to the adjacent node as compared to the current node
                
                
                int neighbour = graph[node][i];
                
                if(color[ neighbour] == -1){
                    color[ neighbour] = 1 - color[node];
                    queue.add( neighbour);
                }
                //if adjacent node is of same color as the current node
                //that means that the someother node might have colored it on some different path
                else if(color[ neighbour] == color[node]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isBipartiteUsingDFS(int start, int currColor, int[][] graph, int[] color){
        color[start] = currColor;
        
        
            for(int i = 0; i < graph[start].length; i++){
                
                //if adjacent node is not yet color, 
                //we need to give opposite color to the adjacent node as compared to the current node
                int neighbour = graph[start][i];
                
                if(color[ neighbour] == -1){
                    if(isBipartiteUsingDFS(neighbour, 1- currColor, graph, color) == false)
                        return false;
                }
                //if adjacent node is of same color as the current node
                //that means that the someother node might have colored it on some different path
                else if(color[ neighbour] ==  currColor){
                    return false;
                }
            }
        
        return true;
        
    }
    public boolean isBipartite(int[][] graph) {
        int vertices = graph.length;
        int[] color = new int[vertices];
        
        for(int i = 0; i < vertices; i++){
            color[i] = -1;
        }
        
        //checking for all the connected conpnent
        for(int i = 0; i < vertices; i++){
            if(color[i] == -1){
                if(isBipartiteUsingDFS(i, 0, graph, color) == false){
                    return false;
                }
            }
        }
        
        return true;
        
    }
}