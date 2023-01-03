class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        
        for(int col = 0; col < strs[0].length(); col++){
            for(int row = 1; row < strs.length; row++){
                //System.out.println(strs[row-1].charAt(col) +"  " + strs[row].charAt(col));
                if(strs[row-1].charAt(col) > strs[row].charAt(col)){
                    count++;
                    break;
                }
            }
        }
        
        return count;
        
    }
}