class Solution {
    public void duplicateZeros(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                temp.add(0);
                temp.add(0);
            }
            else{
                temp.add(arr[i]);
            }
        }
        
        for(int i =0; i < arr.length; i++){
            arr[i] = temp.get(i);
        }
        
    }
}

/*Using extra space*/