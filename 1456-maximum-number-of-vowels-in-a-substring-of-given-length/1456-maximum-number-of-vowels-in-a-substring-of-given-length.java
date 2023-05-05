class Solution {
    private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u')
            return true;
        
        return false;
    }
    
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int currCount = 0;
        
        // Compute vowel count of first window of size k
        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i)))
                currCount++;
        }
        
        // Compute vowel count of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.

        
        maxCount = currCount;
        
        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i-k))) 
                currCount--;
            if(isVowel(s.charAt(i)))
                currCount++;
            
            maxCount = Math.max(currCount, maxCount);
        }
        
        return maxCount;
        
    }
}

// TC O(N) SC O(1)