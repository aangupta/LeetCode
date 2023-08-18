class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        List<Set<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adjList.add(new HashSet<>());
        }
        
        for(int i = 0; i < roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        int max = 0;
        
        for(int i =0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                max = Math.max(max, adjList.get(i).size() + adjList.get(j).size() - (adjList.get(i).contains(j) == true ? 1 : 0));
            }
        }
        
        return max;
        
    }
}