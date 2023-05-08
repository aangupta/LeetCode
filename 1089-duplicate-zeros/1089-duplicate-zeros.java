class Solution {
    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        for(int num: arr){
            if(num == 0)
                zeroCount++;
        }
        
        int i = arr.length-1, j = arr.length + zeroCount - 1;
        
        while(i != j){
            insert(arr, i, j--);
            if(arr[i] == 0){
                insert(arr, i, j--);
            }
            i--;
        }
        
    }
    
    private void insert(int[] arr, int i, int j){
        if(j < arr.length) {
            arr[j] = arr[i];
        }
    }
}