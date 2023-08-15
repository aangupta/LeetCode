class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        
        //creating adjacency list from given pre-requisites
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            for(int neighbour : adjList.get(i)){
                indegree[neighbour]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
    
        
        int index = 0;
        while(queue.size() > 0){
            int node = queue.remove();
            order[index] = node;
            index++;
            
            for(int neighbour : adjList.get(node)){
                indegree[neighbour]--;
                
                if( indegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }
        
        return (index == numCourses ? order : new int[]{});
        
        
    }
}