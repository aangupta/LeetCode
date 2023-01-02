class Solution {
    public boolean detectCapitalUse(String word) {
        
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int wordLength = word.length();
        int index = -1;
        
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch) == true){
                upperCaseCount++;
                if(index == -1)
                    index = i;     
            }
               
            else lowerCaseCount++;
        }
        
        //System.out.println(upperCaseCount+" "+" "+lowerCaseCount +" "+index);
        
        return ((upperCaseCount == wordLength || lowerCaseCount == wordLength || (upperCaseCount == 1 && lowerCaseCount == wordLength-1 && index == 0)) ? true : false);
        
    }
}

//"ffffffffffffffffffffF"