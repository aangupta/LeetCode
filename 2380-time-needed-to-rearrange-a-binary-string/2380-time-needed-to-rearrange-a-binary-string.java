class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int time = 0;
        
        while(true) {
            char[] temp = s.toCharArray();
            int change = 0;
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i-1) == '0' && s.charAt(i) == '1'){
                    change++;
                    temp[i-1] = '1';
                    temp[i] = '0';
                }
                else {
                    //temp[i-1] = s.charAt(i-1);
                    temp[i] = s.charAt(i);
                }
            }
            
            if(change == 0) break;
            
            if(change > 0) time++;
            s = new String(temp);
           
        }
        
        return time;
        
        
    }
}