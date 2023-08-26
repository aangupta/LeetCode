class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> path = new ArrayList<>();
        path.add(0);
        
        findPath(graph, 0, path, result);
        
        return result;
    }
    
    private void findPath(int[][] graph, int node,  List<Integer> path,List<List<Integer>> result) {
        if(node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = 0; i < graph[node].length; i++){
            int adjNode = graph[node][i];
            
            path.add(adjNode);
            
            findPath(graph, adjNode, path, result);
            
            path.remove(path.size()-1);
        }
    }
}

/* DFS + Bracttracking */




/*
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     List<List<Integer>> ans = new LinkedList();
     Queue<List<Integer>> bfs  =new LinkedList();
     bfs.add(Arrays.asList(0));
     int dest = graph.length -1;

     while(!bfs.isEmpty()){
         List<Integer> path = bfs.poll();
         int current = path.get(path.size()-1);
           if(current == dest){
             ans.add(new ArrayList(path));
           }
              for(int node : graph[current]){
                   List<Integer> newPath = new ArrayList(path);
                   newPath.add(node);
                   bfs.add(newPath);
                }
        }
        return ans;

    }
}
*/