//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        int large = Integer.MIN_VALUE;
    	int second_large = Integer.MIN_VALUE;
    	int i;
    	for (i = 0; i < n; i++)
    	{
    		if (arr[i] > large)
    		{
    			second_large = large;
    			large = arr[i];
    		}
    
    		else if (arr[i] > second_large && arr[i] != large)
    		{
    			second_large = arr[i];
    		}
    	}
    	
    	return second_large ==Integer.MIN_VALUE ? -1: second_large;
    }
}