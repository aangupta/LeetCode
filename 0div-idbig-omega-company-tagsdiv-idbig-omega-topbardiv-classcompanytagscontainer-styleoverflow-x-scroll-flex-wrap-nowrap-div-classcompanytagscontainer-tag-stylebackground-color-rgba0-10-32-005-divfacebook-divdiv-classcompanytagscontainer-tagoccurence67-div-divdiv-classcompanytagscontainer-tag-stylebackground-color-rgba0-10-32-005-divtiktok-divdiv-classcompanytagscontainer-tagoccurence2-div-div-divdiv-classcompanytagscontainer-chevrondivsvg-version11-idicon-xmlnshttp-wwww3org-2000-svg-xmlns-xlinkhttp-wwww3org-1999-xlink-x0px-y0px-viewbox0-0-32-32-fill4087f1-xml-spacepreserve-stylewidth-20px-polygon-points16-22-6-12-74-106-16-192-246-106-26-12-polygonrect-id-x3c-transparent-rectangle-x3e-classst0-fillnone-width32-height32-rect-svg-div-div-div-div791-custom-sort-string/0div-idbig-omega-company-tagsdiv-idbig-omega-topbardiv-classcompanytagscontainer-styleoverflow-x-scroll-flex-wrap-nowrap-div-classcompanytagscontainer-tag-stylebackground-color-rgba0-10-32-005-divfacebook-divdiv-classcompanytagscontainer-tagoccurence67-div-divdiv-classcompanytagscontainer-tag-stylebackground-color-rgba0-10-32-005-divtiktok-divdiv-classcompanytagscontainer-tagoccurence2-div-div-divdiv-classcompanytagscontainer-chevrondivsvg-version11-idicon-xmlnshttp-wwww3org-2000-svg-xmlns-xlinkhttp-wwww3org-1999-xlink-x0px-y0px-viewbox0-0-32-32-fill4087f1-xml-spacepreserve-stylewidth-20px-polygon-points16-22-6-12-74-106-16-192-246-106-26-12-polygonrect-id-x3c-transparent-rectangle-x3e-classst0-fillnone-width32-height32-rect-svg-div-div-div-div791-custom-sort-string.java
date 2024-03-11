class Solution {
    public String customSortString(String order, String s) {
        
        int[] freq = new int[26];
        
        //finding the freq of char in s
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < order.length(); i++){
            char ch = order.charAt(i);
            int count = freq[ch - 'a'];
            if(count > 0) {
                for(int j = 1; j <= count; j++)
                    sb.append(ch);
                
                freq[ch -'a'] = 0;
            }
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] > 0) {
                for(int j = 1; j <= freq[s.charAt(i) - 'a']; j++)
                    sb.append(s.charAt(i));
                freq[s.charAt(i) - 'a'] = 0;
            }
        }
        
        return sb.toString();
    }
}