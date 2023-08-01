class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineUtils(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    private void combineUtils( List<List<Integer>> result, List<Integer> tempList, int start, int n, int k){
        
        if(tempList.size() == k){
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = start; i <= n; i++){
            tempList.add(i);
            combineUtils(result, tempList, i+1, n, k);
            tempList.remove(tempList.size()-1);
        }
    }
}