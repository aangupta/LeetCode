class Solution {
   
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) dist[i][j] = 0;
                else 
                    dist[i][j] = (int)1e9;
            }
        }
        
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], d = edge[2];
            dist[u][v] = d;
            dist[v][u] = d;
        }
        
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                   dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        
      
        /*for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                   System.out.print(dist[i][j] + " ");
                }
                 System.out.println();
            }*/
           
        
        
        int cityCount = n, cityInd = -1;
        
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(dist[i][j] <= distanceThreshold)
                    count++;
            }
            
            if(cityCount >= count) {
                cityCount = count;
                cityInd = i;
            }
        }
        
        return cityInd;
        
    }
}