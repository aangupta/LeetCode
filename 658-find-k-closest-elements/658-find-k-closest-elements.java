class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> closetPoints = new ArrayList<>();
        
        int count = 0;
        int start = 0;
        int end = arr.length-1;
        
        while(end - start >= k){
            
            if(Math.abs(arr[start] - x) > Math.abs(arr[end] - x))
                start++;
            else 
                end--;
           
        }
        
        for(int i = start; i <= end; i++)
            closetPoints.add(arr[i]);
        
        return closetPoints;
        
        
        
    }
}