//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    int mod=1000000007;
    //Function to count number of ways to reach the nth stair.
    private int countWaysUtils(int index, int n, int[] dp){
        if(index == 0) return 1;
        
        if(index == 1) return 1;
        
        if(dp[index] != -1) return dp[index];
        
        int oneJump = countWaysUtils(index - 1, n, dp);
        int twoJump = countWaysUtils(index -2 , n, dp);
        
        return dp[index] = (oneJump + twoJump)%mod;
    }
    int countWays(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return  countWaysUtils(n, n, dp);
        
        // your code here
    }
}

