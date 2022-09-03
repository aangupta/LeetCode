class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> numberList = new ArrayList<>();
        
        numsSameConsecDiff(n, k, numberList, 0);
        
        int[] result = new int[numberList.size()];
        
        for(int i = 0; i < numberList.size(); i++){
            result[i] = numberList.get(i);
        }
        
        return result;
        
    }
    
    private void numsSameConsecDiff(int n, int k, List<Integer> numberList, int currentNumber){
        if(n == 0){ //base case
            numberList.add(currentNumber);
            return;
        }
        
        for(int i = 0; i < 10; i++) {
            
            if(i == 0 && currentNumber == 0){ //skipping the scenario of leading zeros
                continue;
            } else if(i != 0 && currentNumber == 0){
                numsSameConsecDiff(n-1, k, numberList, currentNumber * 10 + i);
            } else if(Math.abs(currentNumber%10 - i) == k) {
                 numsSameConsecDiff(n-1, k, numberList, currentNumber * 10 + i);
            }  
        }
    }
}