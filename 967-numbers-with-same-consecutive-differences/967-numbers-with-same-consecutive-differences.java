class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> numberList = new ArrayList<>();
        
        //special case
        if(n == 1)
            numberList.add(0);
        
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
            } else if(i != 0 && currentNumber == 0){  //case where the currentNumber is zero
                numsSameConsecDiff(n-1, k, numberList, currentNumber * 10 + i);
            } else if(Math.abs(currentNumber%10 - i) == k) { ////add the i value at the unit place of the currentNumber (valid case will be when the difference between the unit place of the current number and i is equal to zero)
                 numsSameConsecDiff(n-1, k, numberList, currentNumber * 10 + i);
            }  
        }
    }
}

TC : O(2^n) + o(n) 
SC : O(2^n)
