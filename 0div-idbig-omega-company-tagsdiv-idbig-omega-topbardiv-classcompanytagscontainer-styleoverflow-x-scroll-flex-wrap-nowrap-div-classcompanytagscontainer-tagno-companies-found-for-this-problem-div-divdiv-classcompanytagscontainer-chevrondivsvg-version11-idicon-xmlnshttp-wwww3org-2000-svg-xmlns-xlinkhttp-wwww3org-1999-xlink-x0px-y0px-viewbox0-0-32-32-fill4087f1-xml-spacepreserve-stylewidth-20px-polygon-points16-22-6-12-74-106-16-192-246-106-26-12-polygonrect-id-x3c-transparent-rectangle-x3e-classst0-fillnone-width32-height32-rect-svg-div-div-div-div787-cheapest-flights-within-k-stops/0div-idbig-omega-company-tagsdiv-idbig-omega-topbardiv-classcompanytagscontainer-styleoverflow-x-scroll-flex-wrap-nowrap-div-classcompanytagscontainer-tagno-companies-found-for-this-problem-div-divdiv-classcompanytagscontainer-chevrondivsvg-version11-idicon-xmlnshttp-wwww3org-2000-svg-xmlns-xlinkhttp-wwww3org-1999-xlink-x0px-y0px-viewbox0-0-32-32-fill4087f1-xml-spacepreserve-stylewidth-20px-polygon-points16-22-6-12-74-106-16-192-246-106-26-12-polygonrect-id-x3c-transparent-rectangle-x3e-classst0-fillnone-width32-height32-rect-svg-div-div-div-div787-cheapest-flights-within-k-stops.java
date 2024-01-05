class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] cost = new int[n];
        Arrays.fill(cost, 100000000);
        
        cost[src] = 0;
        
        for(int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n);
            
            for(int[] flight : flights) {
                int flightSrc = flight[0];
                int flightDest = flight[1];
                int flightPrice = flight[2];
                
                if(cost[flightSrc] ==  100000000)
                    continue;
                
                if(temp[flightDest] > cost[flightSrc ] + flightPrice)
                    temp[flightDest] = cost[flightSrc ] + flightPrice;
            }
            
            cost = temp;
            
        }
        
        return (cost[dst] == 100000000 ? -1 : cost[dst] );
    }
}