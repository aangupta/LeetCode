class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        
        int i = n-1;
       
        while(i >= 0) {
            if(i >= 0 && s.charAt(i) == ' '){
                i--;
                continue;
            }
            int j = i;
            while(j >= 0 && s.charAt(j) != ' ')
                j--;
            sb.append(" ");
            sb.append(s.substring(j+1, i+1));
            i = j;
        }
        
        if (sb.length() > 0) sb.deleteCharAt(0);
        return sb.toString();
    }
}