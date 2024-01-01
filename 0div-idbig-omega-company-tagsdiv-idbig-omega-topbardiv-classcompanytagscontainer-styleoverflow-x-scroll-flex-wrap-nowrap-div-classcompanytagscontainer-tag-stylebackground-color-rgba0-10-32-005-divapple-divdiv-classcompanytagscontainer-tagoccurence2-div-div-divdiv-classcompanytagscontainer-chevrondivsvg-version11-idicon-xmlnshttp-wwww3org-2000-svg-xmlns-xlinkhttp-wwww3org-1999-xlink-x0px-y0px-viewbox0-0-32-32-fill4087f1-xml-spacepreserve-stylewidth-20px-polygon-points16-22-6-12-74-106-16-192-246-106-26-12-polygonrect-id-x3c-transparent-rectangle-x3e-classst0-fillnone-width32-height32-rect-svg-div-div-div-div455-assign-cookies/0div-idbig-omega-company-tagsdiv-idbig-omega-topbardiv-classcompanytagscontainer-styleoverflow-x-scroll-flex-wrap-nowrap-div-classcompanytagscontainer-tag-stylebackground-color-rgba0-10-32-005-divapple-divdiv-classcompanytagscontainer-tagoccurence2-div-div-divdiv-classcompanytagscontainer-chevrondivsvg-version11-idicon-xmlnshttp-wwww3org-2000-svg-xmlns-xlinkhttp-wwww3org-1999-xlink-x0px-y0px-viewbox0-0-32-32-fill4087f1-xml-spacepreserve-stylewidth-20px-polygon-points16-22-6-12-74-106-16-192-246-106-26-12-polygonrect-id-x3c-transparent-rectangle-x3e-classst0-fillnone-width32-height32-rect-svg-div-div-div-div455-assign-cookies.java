class Solution {
    public int findContentChildren(int[] children, int[] cookies) {
        if(children.length == 0 || cookies.length == 0)
            return 0;
        
        Arrays.sort(children);
        Arrays.sort(cookies);
        
        int count = 0;
        int i = 0, j = 0;
        
        while(i < cookies.length && j < children.length) {
            if(cookies[i] >= children[j]) {
                count++;
                i++;
                j++;
            }
            else 
                i++;
        }
        return count;
    }
}