class Solution {
    private boolean isConnected(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
            if (diff > 1) return false;
        }
        return true;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.contains(endWord) == false) return 0;
        
        wordList.add(beginWord); //beginWord does not need to be in wordList, so adding to the wordList
        
        Map<String, List<String>> wordGraph = new HashMap<>();
        
        int n = wordList.size();
        
        for(int i = 0; i < n; i++){
            wordGraph.put(wordList.get(i), new ArrayList<>());
        }
        
        //creating adjacency List
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                String a = wordList.get(i);
                String b = wordList.get(j);
                if(isConnected(a,b) == true) {
                    wordGraph.get(a).add(b);
                    wordGraph.get(b).add(a);
                }
            }
        }
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        
        //initialising all wordList values as not visited
        Map<String, Boolean> visited = new HashMap<>();
         for(int i = 0; i < n; i++){
            visited.put(wordList.get(i), false);
        }
        
        queue.add(new Pair<>(beginWord, 1));
        visited.put(beginWord, true);
        
        while(queue.size() > 0) {
            String currWord = queue.peek().getKey();
            int dist = queue.peek().getValue();
            queue.remove();
            
            if(currWord.equals(endWord) == true) return dist;
            
            for(String neighbor : wordGraph.get(currWord)) {
                if(visited.get(neighbor) == false) {
                    visited.put(neighbor, true);
                    queue.add(new Pair<>(neighbor, dist +1));
                }
            }
        }
        return 0;
    }
}