class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        int n = changed.length;
        int index = 0;
        
        if(n % 2 == 1) return new int[0];
        
        int[] result = new int[n/2];
        
        Map<Integer, Integer> count = new TreeMap<>();
        
        for(int a : changed)
            count.put(a, count.getOrDefault(a,0) + 1);
        
        for(int x : count.keySet()){
            
            if(count.get(x) > count.getOrDefault(x + x, 0))
                return new int[0];
            
            for(int i = 0; i < count.get(x); i++){
                result[index++] = x;
                count.put(x + x, count.get(x + x) - 1);
            }
        }
        
        return result;    
    }
}
