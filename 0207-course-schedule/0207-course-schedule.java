class Solution {
    
    private int topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> adj) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }
        
        int count = 0;
        while(queue.size() > 0) {
            int node = queue.remove();
            count++;
            
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }
        return count;
    }
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        
       
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
                    
        for(int i = 0; i < numCourses; i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }

        
        int count = topologicalSort(indegree, adj);
        
        return (count == numCourses ? true : false); 
        
    }
}

/* 
TC O(V+E)
SC O(V) +O(V) 
*/