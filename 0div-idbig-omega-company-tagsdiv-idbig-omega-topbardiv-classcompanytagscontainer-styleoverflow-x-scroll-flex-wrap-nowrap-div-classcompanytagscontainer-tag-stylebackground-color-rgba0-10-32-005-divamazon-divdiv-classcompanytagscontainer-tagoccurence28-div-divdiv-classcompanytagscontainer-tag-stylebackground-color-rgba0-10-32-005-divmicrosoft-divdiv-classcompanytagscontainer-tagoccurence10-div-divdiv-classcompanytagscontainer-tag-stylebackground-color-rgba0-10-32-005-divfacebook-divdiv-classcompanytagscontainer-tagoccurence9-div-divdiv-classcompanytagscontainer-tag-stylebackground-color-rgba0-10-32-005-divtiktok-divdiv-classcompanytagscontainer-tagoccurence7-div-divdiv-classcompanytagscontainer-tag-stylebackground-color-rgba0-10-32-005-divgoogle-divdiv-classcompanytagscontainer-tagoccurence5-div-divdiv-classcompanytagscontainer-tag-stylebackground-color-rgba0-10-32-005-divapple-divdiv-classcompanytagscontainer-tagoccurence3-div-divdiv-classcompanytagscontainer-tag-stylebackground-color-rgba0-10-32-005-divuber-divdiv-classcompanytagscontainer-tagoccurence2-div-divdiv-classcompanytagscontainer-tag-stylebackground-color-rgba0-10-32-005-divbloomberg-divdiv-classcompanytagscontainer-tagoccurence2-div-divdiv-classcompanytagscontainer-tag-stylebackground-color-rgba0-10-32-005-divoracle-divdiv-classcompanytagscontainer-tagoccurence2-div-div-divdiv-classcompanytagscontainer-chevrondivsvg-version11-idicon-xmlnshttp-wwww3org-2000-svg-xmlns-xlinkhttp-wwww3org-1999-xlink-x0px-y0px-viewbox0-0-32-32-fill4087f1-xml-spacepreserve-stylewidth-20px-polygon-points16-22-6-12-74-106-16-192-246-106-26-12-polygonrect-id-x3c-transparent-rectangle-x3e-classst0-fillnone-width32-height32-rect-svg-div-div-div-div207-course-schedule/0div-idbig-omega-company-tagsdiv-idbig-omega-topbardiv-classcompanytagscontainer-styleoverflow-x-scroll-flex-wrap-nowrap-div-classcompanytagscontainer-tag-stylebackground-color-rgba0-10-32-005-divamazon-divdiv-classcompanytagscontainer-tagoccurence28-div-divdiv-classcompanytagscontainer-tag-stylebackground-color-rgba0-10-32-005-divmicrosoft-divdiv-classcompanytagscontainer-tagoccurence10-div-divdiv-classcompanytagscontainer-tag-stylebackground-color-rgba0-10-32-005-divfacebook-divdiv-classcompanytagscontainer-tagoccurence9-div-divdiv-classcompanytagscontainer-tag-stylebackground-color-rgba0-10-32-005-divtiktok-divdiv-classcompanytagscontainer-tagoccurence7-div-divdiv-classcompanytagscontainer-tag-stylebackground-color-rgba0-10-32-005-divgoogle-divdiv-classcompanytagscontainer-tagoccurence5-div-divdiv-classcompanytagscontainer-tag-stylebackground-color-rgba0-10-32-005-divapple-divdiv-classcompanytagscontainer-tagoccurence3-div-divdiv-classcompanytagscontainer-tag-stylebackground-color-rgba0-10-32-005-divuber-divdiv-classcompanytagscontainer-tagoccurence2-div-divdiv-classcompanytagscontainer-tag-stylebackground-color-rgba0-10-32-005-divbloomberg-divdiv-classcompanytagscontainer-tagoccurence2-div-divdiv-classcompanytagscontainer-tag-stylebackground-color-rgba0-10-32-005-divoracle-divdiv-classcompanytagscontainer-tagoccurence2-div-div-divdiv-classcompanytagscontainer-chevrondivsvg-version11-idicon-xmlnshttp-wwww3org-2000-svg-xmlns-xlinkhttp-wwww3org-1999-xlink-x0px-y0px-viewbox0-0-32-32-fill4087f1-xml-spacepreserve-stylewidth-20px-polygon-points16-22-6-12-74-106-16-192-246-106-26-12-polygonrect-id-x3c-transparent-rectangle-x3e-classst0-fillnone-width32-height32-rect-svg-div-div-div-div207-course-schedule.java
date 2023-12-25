class Solution {
    
    private boolean canFinishUtils(int node,  ArrayList<ArrayList<Integer>> adjList,  boolean[] visited, boolean[] visiting) {
        visiting[node] = true;
        
        for(int neighbor : adjList.get(node)) {
            if(visiting[neighbor] == true)
                return false;
            
            if(visited[neighbor] == false) {
                if(canFinishUtils(neighbor, adjList, visited, visiting) == false)
                    return false;
            }
        }
        
        visiting[node] = false;
        visited[node] = true;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
                
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == false) {
                if(canFinishUtils(i, adjList, visited, visiting) == false)
                    return false;
            }
        }
        
        return true;
    }
}

