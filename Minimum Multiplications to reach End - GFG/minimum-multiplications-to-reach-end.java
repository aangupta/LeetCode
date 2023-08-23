//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair {
    int node;
    int steps;
    
    Pair(int node, int steps){
        this.node = node;
        this.steps = steps;
    }
    
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        
        int[] distance = new int[100000];
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i = 0; i < 100000; i++){
            distance[i] = (int)1e9;
        }
        
        distance[start] = 0;
        queue.add(new Pair(start, 0));
        
        while(queue.size() > 0) {
            int currNode = queue.peek().node;
            int currStep = queue.peek().steps;
            
            queue.remove();
            
            if(currNode == end) return currStep;
            
            for(int i = 0; i < arr.length; i++){
                int newStart = (currNode * arr[i]) % 100000;
                
                if(currStep + 1 < distance[newStart]) {
                    distance[newStart] = currStep + 1;
                    queue.add(new Pair(newStart, currStep + 1));
                }
            }
        }
        
        return -1;
    }
}
