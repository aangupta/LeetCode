class Solution {
    private int minTimeToCollectApples(int curr, List<List <Integer>> adj, List<Boolean> hasApple, int parent){
        // variable to keep track of total time
        int time = 0;
        
        // for each neighbor of current node
        for(int child : adj.get(curr)){
            // if the neighbor is the parent node, then we skip
            if(child == parent)
                continue;
            // we recursively call the helper function for each neighbor
            time +=  minTimeToCollectApples(child, adj, hasApple, curr);
        }
        
         // If current node is not the root (0th) node, and it has an apple or any of its descendant has
        //  then we need to add 2 time for moving to and from it
        if(curr != 0 && (hasApple.get(curr) == true|| time > 0))
            time += 2;
        
        return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        // Create an adjacency list to represent the tree
        List<List <Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
         
        // populate the adjacency list
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        return minTimeToCollectApples(0, adj, hasApple, -1);
    }
}

//TC O(V+E) SC O(V+E)