class Solution {
    
    private void dfs(int curRoom,List<List<Integer>> rooms, int[] visited){
        visited[curRoom] = 1;
        
        for(int adjRoom : rooms.get(curRoom)){
            if(adjRoom == curRoom) continue;
            
            if(visited[adjRoom] == 0){
                dfs(adjRoom, rooms, visited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int nRooms = rooms.size();
        int[] visited = new int[nRooms];
        
        dfs(0, rooms, visited);
        
        for(int i = 0; i < nRooms; i++){
            if(visited[i] == 0) return false;
        }
        
        return true;
        
    }
}