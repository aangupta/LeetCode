//Two Pointer Approach
//TC O(n)
//SC O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        
        int[] result = new int[2];
        
        while(start < end) {
            int currSum = numbers[start] + numbers[end];
            
            if(currSum == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
            else if(currSum > target) {
                end--;
            }
            else {
                start++;
            }
        }
        
        return result;
    }
}