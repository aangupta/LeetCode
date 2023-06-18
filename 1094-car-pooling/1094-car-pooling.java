class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        //always check if the key is present in the map or not. If present, update the value.
        for(int[] trip : trips){
            
            map.put(trip[1] , map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2],  map.getOrDefault(trip[2], 0) -trip[0]);
        }
        
        int cap = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
           
            cap += entry.getValue();
            
            if(cap > capacity) return false;
        }
        
        return true;
        
    }
}

