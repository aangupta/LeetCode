class Solution {
    public boolean winnerOfGame(String colors) {
        char[] charArray = colors.toCharArray();
        int n = charArray.length - 1;
        int aCount = 0;
        int bCount = 0;
        
        for(int i = 1; i < n; i++) {
            
            if(charArray[i] == 'A' && charArray[i-1] == 'A' && charArray[i+1] == 'A')
                aCount++;
            
            if(charArray[i] == 'B' && charArray[i-1] == 'B' && charArray[i+1] == 'B')
                bCount++;
        }
        
        if(aCount != 0 && aCount > bCount)
            return true;
        
        return false;
        
    }
}