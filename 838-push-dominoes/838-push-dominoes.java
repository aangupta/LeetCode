class Solution {
    public String pushDominoes(String dominoes) {
        
        if(dominoes==null){
            return null;
        }
        
        int[] left = new int[dominoes.length()+1];
        int[] right = new int[dominoes.length()+1];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        for(int i=0; i<dominoes.length(); i++){
            if(dominoes.charAt(i)!='L'){
                right[i+1]= dominoes.charAt(i)=='.' ? (right[i] != Integer.MAX_VALUE? right[i]+1 : Integer.MAX_VALUE  )  : 1;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i =dominoes.length()-1;i>=0; i--){
            if(dominoes.charAt(i)!='R'){
                left[i]= dominoes.charAt(i)=='.' ? (left[i+1] != Integer.MAX_VALUE? left[i+1]+1 : Integer.MAX_VALUE  )  : 1;
            }
            if(left[i]==right[i+1]){
                result.insert(0, ".");
            } else if(left[i]<right[i+1]){
                result.insert(0, "L");
            } else {
                 result.insert(0, "R");
            }
        }
        return result.toString();
        
    }
}