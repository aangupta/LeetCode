class Solution {
    public String removeKdigits(String num, int k) {
        
        //corner case
        if(num.length() == k) return "0";
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        stack.push(num.charAt(0));
        
        for(int i = 1; i < num.length(); i++){
            
            //whenever meet a digit which is less than the previous digit, discard the previous one
            //40040 - stack will be empty after one while loop, so adding condition stack.size > 0
            while(stack.size() > 0 && k > 0 && stack.peek() > num.charAt(i)){
                k--;
                stack.pop();
            }
            
            //if stack is empty and num[i] is zero, that means it is a trailing zero 
            //we will not push it to the stack and push the rest num.
            if(stack.size() == 0 && num.charAt(i) =='0') continue;
            
            stack.push(num.charAt(i));
        }
        
        // for non-decreasing num eg 123456 or 55555 and k > 0, we need to remove k elemnets from last
        while(stack.size() > 0 && k > 0){
            stack.pop();
            k--;
        }
        
        //"10200" k = 2
        if(stack.size() == 0) return "0";
        
        //in stack the value are store in way that the larger element is at top and smaller at bottom, so we have to reverse the resultant num.
        while(stack.size() > 0){
            sb.append(stack.peek());
            stack.pop();
        }
        
        return sb.reverse().toString();
         
        
    }
}