//TC O(n)
//SC O(n)

//Idea is to find replace the 0s with -1
//now we need to find the longest subarray who's sum equals to 0 (beacuse in that subarray the no of 1s == no of -1s)
//
class Solution {
    
    public int findMaxLength(int[] nums) {
        int length = 0;
        int currSum = 0;
        
        //map<currSum, index>
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(currSum, -1);
        
        for(int i = 0; i < nums.length; i++) {
            currSum += (nums[i] == 0 ? -1 : 1);
            
            //if the currSum is already seen previously at index j
            //that means from index j+ 1 to current index i, the summ of elements is zero
            //which means in that subarray we have eqaul number of 1s and equal number of 0s
            if(map.containsKey(currSum) == true) {
                length = Math.max(length, i - map.get(currSum));
            }
            else {
                map.put(currSum, i);
            }
        }
        
        return length;
    }
}

/* 
NOTES - This falls under the same pattern as Leetcode - 560, 930, 1074
Leetcode-560, 1074 - https://youtu.be/-SWrz90jCUM?si=9dnkn65t_pgeHgyA
Leetcode 930 - https://youtu.be/5Quv9nnZs34?si=aMNPNqLGPaoluWrR
*/