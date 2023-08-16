class Solution {
    private void buildAdjacencyList(int n, int[][] edges,   ArrayList<ArrayList<Integer>> adjList, int[] indegree) {
        
        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
            
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        
        /* edge case 
        this is needed...since when there is only 1 vertex... the indegree of it will be 0..this case is not included in the following discussion... */
        if(n == 1){
            result.add(0);
            return result;
        }
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        buildAdjacencyList(n, edges, adjList, indegree);
        
        Queue<Integer> queue = new LinkedList<>();
        
        //adding all leave nodes to the queue, where indegree is 1
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 1) queue.add(i); 
        }
        
        int nodeCount = n;
        
       
        
        while(queue.size() > 0){
            int size = queue.size();
            nodeCount = nodeCount - size;
            
            result.clear();
            for(int i = 0; i < size; i++){ 
                int node = queue.remove();
                result.add(node);
                
                for(int j = 0; j < adjList.get(node).size(); j++){
                    int neighbour = adjList.get(node).get(j);
                    //System.out.println(neighbour);
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 1){
                        //System.out.println(neighbour);
                        queue.add(neighbour);
                    }
                        
                }
            }
        }
        
        result.addAll(queue);
        return result;
    }
}