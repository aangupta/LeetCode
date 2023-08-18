class Pair {
    String word;
    int dist;
    
    Pair(String word, int dist) {
        this.word = word;
        this.dist = dist;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < wordList.size(); i++){
            set.add(wordList.get(i));
        }
        
        set.remove(beginWord);
        queue.add(new Pair(beginWord,1));
        
        while(queue.size() > 0){
            String currWord = queue.peek().word;
            int currDist = queue.peek().dist;
            
            queue.remove();
            if(currWord.equals(endWord) == true) return currDist;
            
            for(int i = 0; i < currWord.length(); i++){
                for(char ch = 'a'; ch <='z'; ch++){
                    char[] replacedCharArray = currWord.toCharArray();
                    replacedCharArray[i] = ch;
                    
                    String replacedString = new String(replacedCharArray);
                    
                    if(set.contains(replacedString) == true){
                        set.remove(replacedString);
                        queue.add(new Pair(replacedString, currDist + 1));
                    }
                    
                }
                
            }
        }
        
        
        return 0;
    }
}