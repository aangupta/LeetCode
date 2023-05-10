class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        
        for(int val : arr){
            if(set.contains(2 * val) || val%2 == 0 && set.contains(val/2))
                return true;
            
            set.add(val);
        }
        return false;
        
    }
}


/* check for this test case 
[-2,0,10,-19,4,6,-8] 
*/