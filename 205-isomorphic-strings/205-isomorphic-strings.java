class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        char[] mapST = new char[256];
        char[] mapTS = new char[256];

        for (int i = 0; i < s.length(); i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if (mapST[s1] == 0 && mapTS[t1] == 0) {
                mapST[s1] = t1;
                mapTS[t1] = s1;
            }else if(mapST[s1] != t1){
                return false;
            }
        }

        return true;
        
    }
}