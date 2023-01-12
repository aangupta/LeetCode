class Solution {
    
    private void countSubTreesUtils(int curr, int parent, List<List <Integer> > adj, int[] freq, String labels , int[] res){
        
        char label = labels.charAt(curr);
        int count = freq[label - 'a'];
        
        freq[label - 'a']++;
        
        for(int child : adj.get(curr)){
            
            if(child == parent)
                continue;
            
            countSubTreesUtils(child, curr, adj, freq, labels, res);
        }
        
        res[curr] = freq[label - 'a'] - count;
       
        
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        List<List <Integer> > adj = new ArrayList<>();
        //Map<Character, Integer> labelCount = new HashMap<>();
        
        int[] res = new int[n];
        int[] freq = new int[26];
        
        for(int i =0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        countSubTreesUtils(0, -1, adj, freq, labels, res);
        return res;
        
    
        
    }
}


//Just Store the count of current node in the frequency array before going for subtree traversal and then post completion of traversal -> ans [node] = total Frequency Till Now - initialCount;