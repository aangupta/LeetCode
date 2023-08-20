//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i <=n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            
            adjList.get(u).add(new Pair(v, weight));
            adjList.get(v).add(new Pair(u, weight));
        }
        
        int[] distance = new int[n+1];
        int[] parent = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            distance[i] = (int)1e9;
            parent[i] = i;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(1, 0));
        distance[1] = 0;
        
        while(pq.size() > 0){
            int currNode = pq.peek().node;
            int currPathLen = pq.peek().weight;
            pq.remove();
            
            for(int i = 0; i < adjList.get(currNode).size(); i++) {
                Pair iter = adjList.get(currNode).get(i);
                int adjNode = iter.node;
                int edgeW = iter.weight;
                
                if(currPathLen + edgeW < distance[adjNode]){
                    distance[adjNode] = currPathLen + edgeW;
                    parent[adjNode] = currNode;
                    pq.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        
        //if end node is not reachable
        List<Integer> path = new ArrayList<>();  

        // If distance to a node could not be found, return an array containing -1.
        if(distance[n] == 1e9) {
            path.add(-1); 
            return path; 
        }
        
        int node = n;
        // o(N)
        while(parent[node] != node) {
            path.add(node); 
            node = parent[node]; 
        }
        path.add(1); 

        // Since the path stored is in a reverse order, we reverse the array
        // to get the final answer and then return the array.
        Collections.reverse(path); 
        return path;
        
        
    }
}