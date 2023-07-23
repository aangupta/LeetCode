class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        for(int asteriod : asteroids){
            
            if(asteriod > 0) list.add(asteriod);
            
            else {
                while(list.size() > 0 && list.getLast() > 0 && list.getLast() < -asteriod)
                    list.pollLast();
                if(list.size() > 0 && list.getLast() == -asteriod)
                    list.pollLast();
                else if(list.size() == 0 || list.getLast() < 0)
                    list.add(asteriod);
            } 
        }
        
        if(list.size() == 0) return new int[]{};
        
        int[] result = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}