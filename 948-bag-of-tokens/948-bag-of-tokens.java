class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        //Power Down : Loose power equal to current token and increase score by 1
        //Power Up : Gain power equal to current token and decrease score by 1
        Arrays.sort(tokens);
        
        int left = 0;
        int right = tokens.length-1;
        
        int maxScore = 0;
        int score = 0;
        
        while(left <= right){
            if(power >= tokens[left]){
                power = power - tokens[left];
                score = score + 1;
                left++;
            } else if(score > 0){
                power = power + tokens[right];
                score = score - 1;
                right--;
            }
            else {
                break;
            }
            
            maxScore = Math.max(score, maxScore);
        }
        
        return maxScore;
        
    }
    
    //TC (nlogn) SC O(1)
}