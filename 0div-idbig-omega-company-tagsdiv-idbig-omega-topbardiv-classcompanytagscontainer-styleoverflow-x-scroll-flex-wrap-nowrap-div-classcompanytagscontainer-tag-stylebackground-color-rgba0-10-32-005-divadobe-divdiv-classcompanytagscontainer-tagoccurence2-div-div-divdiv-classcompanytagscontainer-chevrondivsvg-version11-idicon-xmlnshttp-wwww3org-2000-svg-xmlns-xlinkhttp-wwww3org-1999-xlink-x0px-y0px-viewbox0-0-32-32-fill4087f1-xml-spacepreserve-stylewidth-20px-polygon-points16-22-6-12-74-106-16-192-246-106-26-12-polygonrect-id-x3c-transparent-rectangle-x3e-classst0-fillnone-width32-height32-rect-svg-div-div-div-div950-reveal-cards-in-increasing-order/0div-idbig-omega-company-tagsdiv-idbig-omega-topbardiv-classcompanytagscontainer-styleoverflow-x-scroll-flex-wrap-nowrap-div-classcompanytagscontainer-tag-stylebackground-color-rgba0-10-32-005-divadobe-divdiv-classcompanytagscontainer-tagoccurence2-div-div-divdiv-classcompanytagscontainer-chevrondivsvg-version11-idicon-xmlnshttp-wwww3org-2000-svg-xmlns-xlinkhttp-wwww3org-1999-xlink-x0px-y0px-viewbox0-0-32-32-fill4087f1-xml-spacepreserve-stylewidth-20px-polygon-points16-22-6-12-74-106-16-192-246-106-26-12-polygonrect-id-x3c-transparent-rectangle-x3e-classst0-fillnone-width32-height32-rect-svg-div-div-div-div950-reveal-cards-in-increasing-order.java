class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int length = deck.length;
        Arrays.sort(deck);
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < length; i++) 
            queue.add(i);
        
        int[] result = new int[length];
        
        for(int i = 0; i < length; i++) {
            result[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        
        return result;
    }
}