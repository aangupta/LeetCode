class Solution {
    public int findCenter(int[][] edges) {
        //Idea is to create adjList and which ever node's adlist isze is n-1, return that node
        //1 -> 2
        //2 -> 1,3,4 start node
        //3 -> 2
        //4 -> 2
        
        //map of <node, no of connected node> 
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            map.put(u, map.getOrDefault(u, 0) + 1);
            map.put(v, map.getOrDefault(v, 0) + 1);  
        }
        
        int max = 0;
        int startNode = 0;
        
        for(int key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                startNode = key;
            }
        }
        return startNode;
    }
}