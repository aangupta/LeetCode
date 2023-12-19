class Solution {
    /*Idea is to find no of connected component*/
    //bfs solution
    private void bfs(int node, int[] visited, int[][] isConnected) {
       Queue<Integer> queue = new LinkedList<>();
        
        visited[node] = 1;
        queue.add(node);
        
        while(queue.size() > 0) {
            int currNode = queue.remove();

            //traversing through the adjacent nodes
            for(int i = 0; i < isConnected[currNode].length; i++){
                if(isConnected[currNode][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
        
    }
    public int findCircleNum(int[][] isConnected) {
        int noOfProvinces = 0;
        
        int vertices = isConnected.length;
        int visited[] = new int[vertices];
        
        for(int i = 0; i < vertices; i++){
            if(visited[i] == 0){
                noOfProvinces++;
                bfs(i, visited, isConnected);
            }
        }
        
        return noOfProvinces;   
    }
}
