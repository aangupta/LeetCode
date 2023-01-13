//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    private int minimumEnergyUtils(int index, int[] arr, int n, int[] dp){
        
        if(index == 0) return 0;
        
        if(dp[index] != -1) return dp[index];
        
        int jumpTwoSteps = Integer.MAX_VALUE;
        
        int jumpOneStep = minimumEnergyUtils(index - 1, arr, n, dp) + Math.abs(arr[index] - arr[index -1]);
        
        if(index > 1)
            jumpTwoSteps = minimumEnergyUtils(index - 2, arr, n, dp) + Math.abs(arr[index] - arr[index -2]);
            
        return dp[index] = Math.min(jumpOneStep, jumpTwoSteps);
    }
    public int minimumEnergy(int arr[],int N){
        int[] dp = new int[N];
        
        Arrays.fill(dp, -1);
        return minimumEnergyUtils(N-1,arr, N, dp);
    }
}