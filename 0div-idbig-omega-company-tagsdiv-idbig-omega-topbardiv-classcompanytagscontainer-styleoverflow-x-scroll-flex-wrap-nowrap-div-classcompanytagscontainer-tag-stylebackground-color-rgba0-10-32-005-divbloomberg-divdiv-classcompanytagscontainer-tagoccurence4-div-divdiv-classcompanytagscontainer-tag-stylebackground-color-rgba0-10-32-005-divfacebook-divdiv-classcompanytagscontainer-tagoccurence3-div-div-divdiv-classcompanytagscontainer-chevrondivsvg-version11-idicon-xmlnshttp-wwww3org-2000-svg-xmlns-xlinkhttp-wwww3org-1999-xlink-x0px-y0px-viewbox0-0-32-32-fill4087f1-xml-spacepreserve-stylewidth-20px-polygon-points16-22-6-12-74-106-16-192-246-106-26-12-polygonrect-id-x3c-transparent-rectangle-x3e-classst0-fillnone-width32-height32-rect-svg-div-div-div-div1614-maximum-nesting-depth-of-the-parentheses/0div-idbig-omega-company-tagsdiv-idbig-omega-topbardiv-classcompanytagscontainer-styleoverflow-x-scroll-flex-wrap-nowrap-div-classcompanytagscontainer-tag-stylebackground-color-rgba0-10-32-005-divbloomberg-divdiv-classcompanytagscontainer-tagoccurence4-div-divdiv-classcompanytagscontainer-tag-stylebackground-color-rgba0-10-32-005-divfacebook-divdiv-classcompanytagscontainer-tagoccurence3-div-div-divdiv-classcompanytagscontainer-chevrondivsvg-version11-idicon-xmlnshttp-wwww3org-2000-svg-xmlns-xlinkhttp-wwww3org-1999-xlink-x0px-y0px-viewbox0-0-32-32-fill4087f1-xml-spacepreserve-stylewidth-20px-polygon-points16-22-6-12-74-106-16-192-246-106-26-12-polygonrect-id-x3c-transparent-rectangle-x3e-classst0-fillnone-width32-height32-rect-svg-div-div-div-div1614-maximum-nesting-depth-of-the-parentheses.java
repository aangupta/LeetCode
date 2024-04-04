class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int openBrackets = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                openBrackets++;
            }
            else if(c == ')') {
                openBrackets--;
            }
            
            maxDepth = Math.max(maxDepth, openBrackets);
        }
        
        return maxDepth;
    }
}

//TC O(n)
//SC O(1)