class Solution {
    //Greedy Appraoch
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0; //count of nums who;'s value got updated after doing the XOR
        int minLoss = Integer.MAX_VALUE;  //keep track of minLoss (value which gives min (num ^ k) - num))
        
        for(int num : nums) {
            
            if((num ^ k) > num) {
                sum += (num ^ k);
                count++;
            }
            else {
                sum += num;
            }
            
            minLoss = Math.min(minLoss, Math.abs((num ^ k) - num));
        }
        
        return (count % 2 == 0 ? sum : sum - minLoss);
    }
}

//T.C : O(n)
//S.C : O(1)

/*
Idea is to take the XOR of each value of num
if after doing XOR with num the original value of num is increasing add the update value to sum and increae the count value 
if not add the original value of num to sum
keep track of the minLoss 

at last if count value is even, that means we have applied XOr to pair of nodes, so return the sum.
if count is odd that means we haven't applied the XOR to pair of node (edge) so return sum - minLoss

** since it is an undirected graph or tree so there is a path from one node to another

*/