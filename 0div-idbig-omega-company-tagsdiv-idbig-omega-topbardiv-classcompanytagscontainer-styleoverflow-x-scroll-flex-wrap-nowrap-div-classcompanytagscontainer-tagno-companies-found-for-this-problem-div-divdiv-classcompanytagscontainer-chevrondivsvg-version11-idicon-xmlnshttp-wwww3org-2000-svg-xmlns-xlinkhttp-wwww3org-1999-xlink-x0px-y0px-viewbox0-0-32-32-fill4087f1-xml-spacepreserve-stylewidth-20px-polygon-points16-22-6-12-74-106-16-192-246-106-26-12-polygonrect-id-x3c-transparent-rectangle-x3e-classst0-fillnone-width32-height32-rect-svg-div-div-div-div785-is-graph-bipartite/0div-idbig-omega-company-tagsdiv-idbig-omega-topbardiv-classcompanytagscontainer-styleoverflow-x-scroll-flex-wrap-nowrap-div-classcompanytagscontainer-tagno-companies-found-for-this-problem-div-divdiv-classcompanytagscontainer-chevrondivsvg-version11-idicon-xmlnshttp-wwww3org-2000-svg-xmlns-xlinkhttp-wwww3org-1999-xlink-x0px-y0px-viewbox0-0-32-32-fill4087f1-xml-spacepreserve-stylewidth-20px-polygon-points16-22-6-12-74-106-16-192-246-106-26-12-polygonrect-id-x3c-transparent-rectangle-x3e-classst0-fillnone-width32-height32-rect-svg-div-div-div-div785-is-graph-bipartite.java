class Solution {

    //BFS
    private boolean isBipartiteUtils(int start, int currColor, int[][] graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = currColor;
        
        while(queue.size() > 0) {
            int node = queue.peek();
            queue.remove();
            
            for(int neighbour : graph[node]) {
                //if adjacent node is not yet color,
                //we need to give opposite color to the adjacent node as compared to the current node
                if(color[neighbour] == -1) {
                    color[neighbour] = 1 - color[node];
                    queue.add(neighbour);
                }
                //if adjacent node is of same color as the current node
                //that means that the someother node might have colored it on some different path
                else if(color[neighbour] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int vertices = graph.length;
        int[] color = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            color[i] = -1;
        }

        //checking for all the connected conpnent
        for (int i = 0; i < vertices; i++) {
            if (color[i] == -1) {
                if (isBipartiteUtils(i, 0, graph, color) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}
