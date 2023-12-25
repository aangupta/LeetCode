class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.contains(endWord) == false) return 0;
        
        Set<String> set = new HashSet<>();
        int n = wordList.size();
        for(int i = 0; i < n; i++)
            set.add(wordList.get(i));
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        
        queue.add(new Pair<>(beginWord, 1));
        set.remove(beginWord);
        
        while(queue.size() > 0) {
            String currWord = queue.peek().getKey();
            int dist = queue.peek().getValue();
            queue.remove();
            
            if(currWord.equals(endWord) == true) return dist;
            
             for(int i = 0; i < currWord.length(); i++){
                for(char ch = 'a'; ch <='z'; ch++){
                    char[] replacedCharArray = currWord.toCharArray();
                    replacedCharArray[i] = ch;
                    
                    String replacedString = new String(replacedCharArray);
                    
                    if(set.contains(replacedString) == true){
                        set.remove(replacedString);
                        queue.add(new Pair<>(replacedString, dist + 1));
                    }
                    
                }
                
            }
        }
        return 0;
    }
}