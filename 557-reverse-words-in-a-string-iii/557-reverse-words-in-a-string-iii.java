class Solution {
    public String reverseWords(String s) {
        
        char[] charArray = s.toCharArray();
        
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] != ' '){ //when i is nonspace char
                int j = i;
                
                while(j + 1 < charArray.length && charArray[j+1] != ' ') //move j to the end of the word
                    j++;
                
                reverse(charArray, i, j);
                
                i = j;
            }
        }
        
        return new String(charArray);
    }
    
    private void reverse(char[] charArray, int i, int j){
        
        while(i < j){
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
    }
}