class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] words = s.split(" ");
        
        if(words.length != pattern.length())
            return false;
        
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++){
            char letter = pattern.charAt(i);
            String word = words[i];
            
            if(charToWord.containsKey(letter) == false)
                charToWord.put(letter, word);
            
            if(wordToChar.containsKey(word) == false)
                wordToChar.put(word, letter);
            
            if(!wordToChar.get(word).equals(letter) || !charToWord.get(letter).equals(word))
                return false;
        }
        
        return true;
        
    }
}
/* 
pattern = "abba", s = "dog cat cat dog"

charToWord
a -> dog
b -> cat


WordToChar
dog -> a
cat -> b

*/