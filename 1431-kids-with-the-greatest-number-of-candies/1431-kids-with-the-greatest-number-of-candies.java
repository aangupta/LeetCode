class Solution {
    public int findMax(int[]candies){
        int max = 0;
        for(int candy : candies){
            max = Math.max(candy, max);
        }
        return max;
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int max = findMax(candies);
        List<Boolean> result = new ArrayList<>();
        
        for(int candy : candies){
            if(candy + extraCandies >= max)
                result.add(true);
            else result.add(false);
        }
        
        return result;
        
    }
}