class Solution {
    
    private void reverse( char[] wordArray, int start, int end) {
        
        while(start <= end) {
            char temp =  wordArray[start];
            wordArray[start] =  wordArray[end];
            wordArray[end] = temp;
            start++;
            end--;
        }
    }
    public String reversePrefix(String word, char ch) {
        char[] wordArray = word.toCharArray();  
        
        
        //finding the first occurrence of ch
        int index = -1;
        for(int i = 0; i < wordArray.length; i++) {
            if(wordArray[i] == ch){
               index = i;
                break;
            }
        }
        
        //if char found, reverse the string from [0 to index]
        if(index != -1){
            reverse(wordArray, 0, index);
            return new String(wordArray);
        }
        
        return word;
        
    }
}