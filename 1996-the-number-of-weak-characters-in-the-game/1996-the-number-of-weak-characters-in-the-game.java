class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        // if we sort only by 1st indexes, there could be values where 1st index is the same 
        // Arrays.sort(properties, (a,b) -> Integer.compare(a[0], b[0]));
        
        
        // b[1], a[1] because we need the 2nd values in descending order
        
        Arrays.sort(properties, new Comparator<int[]> () {
           
            @Override
            public int compare(int[] a, int[] b) {
                
                if(a[0] == b[0]){
                    if(a[1] > b[1])
                        return -1;
                    else 
                        return 1;
                    
                }
                else if(a[0] > b[0])
                    return 1;
                else
                    return -1;     
            }
        });
        
        
        int maximum = Integer.MIN_VALUE;
        int noOfWeakCharacters = 0;
        
        for(int i = properties.length-1; i >= 0; i--){
            
            if(properties[i][1] < maximum)
              noOfWeakCharacters++;
            
            maximum = Math.max(maximum, properties[i][1]);
        }
        
        return noOfWeakCharacters;
        
    }
    /* TC O(nlogn) Sc O(1)*/
}