class Solution {
    public int pivotInteger(int n) {
        int[] arr = new int[n+1];
        
        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        
        int[] leftSum = new int[n+1];
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += arr[i];
            leftSum[i] = sum;
        }
        
        int[] rightSum = new int[n+1];
        sum = 0;
        for(int i = n; i >=1; i--) {
            sum += arr[i];
            rightSum[i] = sum;
        }
        
        for(int i = 1; i <= n; i++) {
            if(leftSum[i] == rightSum[i])
                return i;
        }
        
        return -1;
        
    }
}