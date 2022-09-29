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

We can initialize two pointers L=0 and R=n-1. 
Now our window size is n and contains excess elements. 
We will keep reducing the [L, R] window size till it becomes exactly equal to k. 
We can do this based on the condition - x - arr[L] <= arr[R] - x. 
If it is true, then it means arr[R] is farther away from x than arr[L] and thus we will eliminate arr[R]. Otherwise, we will eliminate arr[L].
