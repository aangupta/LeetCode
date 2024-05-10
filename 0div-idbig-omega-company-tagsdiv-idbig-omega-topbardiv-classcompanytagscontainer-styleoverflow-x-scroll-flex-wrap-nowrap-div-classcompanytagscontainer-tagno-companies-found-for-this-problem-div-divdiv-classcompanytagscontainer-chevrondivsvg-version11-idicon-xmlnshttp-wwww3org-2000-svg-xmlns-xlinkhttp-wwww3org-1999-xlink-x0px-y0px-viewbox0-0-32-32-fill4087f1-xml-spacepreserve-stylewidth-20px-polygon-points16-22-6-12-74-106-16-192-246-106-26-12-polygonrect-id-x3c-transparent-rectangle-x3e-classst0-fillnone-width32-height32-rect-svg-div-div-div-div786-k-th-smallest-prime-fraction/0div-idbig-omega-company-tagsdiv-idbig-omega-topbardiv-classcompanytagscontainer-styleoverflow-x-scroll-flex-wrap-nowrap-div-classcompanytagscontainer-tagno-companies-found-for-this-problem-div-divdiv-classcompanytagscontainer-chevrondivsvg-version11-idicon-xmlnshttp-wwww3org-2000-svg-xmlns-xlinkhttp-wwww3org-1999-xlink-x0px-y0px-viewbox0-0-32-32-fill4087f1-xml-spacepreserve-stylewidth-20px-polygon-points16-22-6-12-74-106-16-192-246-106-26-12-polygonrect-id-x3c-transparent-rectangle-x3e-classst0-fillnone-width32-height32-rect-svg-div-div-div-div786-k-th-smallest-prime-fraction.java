class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[] > minHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) a[0] / a[1]));
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                minHeap.add(new int[]{arr[i], arr[j]});
            }
        }
        
        int[] result = new int[2];
        for(int i = 0; i < k; i++) {
            result = minHeap.poll();
        }
        
        return result;
    }
}