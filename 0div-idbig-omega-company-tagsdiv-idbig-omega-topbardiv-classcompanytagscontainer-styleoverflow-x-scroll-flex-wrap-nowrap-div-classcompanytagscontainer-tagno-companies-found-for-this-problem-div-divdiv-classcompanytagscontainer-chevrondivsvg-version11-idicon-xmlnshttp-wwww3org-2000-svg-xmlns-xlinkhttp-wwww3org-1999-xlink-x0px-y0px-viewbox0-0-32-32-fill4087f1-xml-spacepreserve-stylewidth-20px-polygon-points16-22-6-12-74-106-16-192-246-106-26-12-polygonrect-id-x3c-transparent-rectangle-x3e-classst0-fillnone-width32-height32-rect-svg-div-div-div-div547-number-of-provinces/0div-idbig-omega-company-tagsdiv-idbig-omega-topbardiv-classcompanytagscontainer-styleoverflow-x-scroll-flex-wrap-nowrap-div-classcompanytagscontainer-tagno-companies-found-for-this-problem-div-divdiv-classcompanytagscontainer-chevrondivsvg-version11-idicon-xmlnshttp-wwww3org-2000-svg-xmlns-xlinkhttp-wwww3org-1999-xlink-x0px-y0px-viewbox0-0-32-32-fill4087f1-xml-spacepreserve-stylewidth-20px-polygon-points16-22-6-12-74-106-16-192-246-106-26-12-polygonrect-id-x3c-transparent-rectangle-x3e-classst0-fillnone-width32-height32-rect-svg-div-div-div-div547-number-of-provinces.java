class Solution {
    /*Idea is to find no of connected component*/
    //dfs solution
    private void dfs(int node, int[] visited, int[][] isConnected) {
        visited[node] = 1;
        
        for(int i = 0; i < isConnected[node].length; i++){
            if(isConnected[node][i] == 1 && visited[i] == 0){
                dfs(i, visited, isConnected);
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
                dfs(i, visited, isConnected);
            }
        }
        
        return noOfProvinces;   
    }
}
