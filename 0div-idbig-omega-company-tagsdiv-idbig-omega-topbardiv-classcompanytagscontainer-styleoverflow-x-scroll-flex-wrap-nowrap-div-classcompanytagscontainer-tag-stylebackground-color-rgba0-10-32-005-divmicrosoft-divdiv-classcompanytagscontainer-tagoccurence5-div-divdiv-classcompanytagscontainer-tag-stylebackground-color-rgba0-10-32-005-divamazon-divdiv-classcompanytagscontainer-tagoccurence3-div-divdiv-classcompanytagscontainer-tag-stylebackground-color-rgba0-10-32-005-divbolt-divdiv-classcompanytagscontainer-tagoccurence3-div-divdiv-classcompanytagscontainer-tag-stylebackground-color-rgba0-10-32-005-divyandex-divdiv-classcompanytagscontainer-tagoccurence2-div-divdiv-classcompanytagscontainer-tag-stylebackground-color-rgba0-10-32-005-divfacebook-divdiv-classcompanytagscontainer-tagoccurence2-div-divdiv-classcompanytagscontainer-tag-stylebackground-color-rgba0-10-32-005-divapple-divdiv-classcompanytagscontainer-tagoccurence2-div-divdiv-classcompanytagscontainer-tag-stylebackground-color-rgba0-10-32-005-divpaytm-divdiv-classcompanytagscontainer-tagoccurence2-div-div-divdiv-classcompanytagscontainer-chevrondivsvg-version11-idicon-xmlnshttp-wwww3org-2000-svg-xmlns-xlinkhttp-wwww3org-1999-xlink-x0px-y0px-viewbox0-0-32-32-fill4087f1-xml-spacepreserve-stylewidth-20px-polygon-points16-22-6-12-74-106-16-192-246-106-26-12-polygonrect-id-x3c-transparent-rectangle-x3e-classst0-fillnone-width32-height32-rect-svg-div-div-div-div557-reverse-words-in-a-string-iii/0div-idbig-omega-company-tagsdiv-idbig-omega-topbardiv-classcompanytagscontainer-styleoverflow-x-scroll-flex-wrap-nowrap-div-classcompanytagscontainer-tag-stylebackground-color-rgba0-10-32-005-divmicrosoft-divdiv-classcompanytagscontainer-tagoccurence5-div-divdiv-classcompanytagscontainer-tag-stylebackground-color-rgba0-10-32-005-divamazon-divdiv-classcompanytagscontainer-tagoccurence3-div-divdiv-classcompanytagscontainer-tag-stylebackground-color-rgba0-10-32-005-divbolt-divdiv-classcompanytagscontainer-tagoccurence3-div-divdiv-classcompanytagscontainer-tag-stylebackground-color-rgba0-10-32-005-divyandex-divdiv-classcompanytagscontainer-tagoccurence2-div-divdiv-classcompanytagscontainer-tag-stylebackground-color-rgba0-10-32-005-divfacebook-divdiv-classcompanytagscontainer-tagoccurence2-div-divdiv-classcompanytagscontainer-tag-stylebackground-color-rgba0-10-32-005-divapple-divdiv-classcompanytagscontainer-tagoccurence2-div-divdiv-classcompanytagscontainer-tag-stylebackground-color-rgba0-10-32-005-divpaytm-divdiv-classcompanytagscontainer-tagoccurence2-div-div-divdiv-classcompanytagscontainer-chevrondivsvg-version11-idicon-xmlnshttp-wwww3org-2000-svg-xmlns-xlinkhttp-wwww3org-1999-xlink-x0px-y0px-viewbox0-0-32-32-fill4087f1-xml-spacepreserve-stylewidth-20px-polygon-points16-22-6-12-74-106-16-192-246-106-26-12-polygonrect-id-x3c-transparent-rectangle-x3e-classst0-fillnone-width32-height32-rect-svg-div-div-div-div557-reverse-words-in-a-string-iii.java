class Solution {
    public String reverseWords(String s) {
        
        char[] charArray = s.toCharArray();
        
        int i, j;
        
        for(i = 0; i < charArray.length; i++){
            
            if(charArray[i] != ' ') {
                j = i;
                
                while(j+1 < charArray.length && charArray[j+1] != ' ')
                    j++;
                
                reverse(charArray, i, j);
                
                i = j;
            }
        }
        
        return new String(charArray);
        
    }
    
    private void reverse(char[] charArray, int i, int j) {
        char temp;
        
        while(i < j) {
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
    }
}