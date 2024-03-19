class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(tasks.length == 0) return 0;
        
        int[] taskCount = new int[26];
        
        for(char ch : tasks) taskCount[ch - 'A']++;
        
        PriorityQueue<Task> maxPQ = new PriorityQueue<>((a,b) -> (b.count - a.count));
        
        // Prepare priority queue of Task
        for(int i = 0; i < 26; i++){
            if(taskCount[i] > 0) maxPQ.offer(new Task(i, taskCount[i]));
        }
        
        int time = 0;
        
        // process queue and count for each section, where k = n + 1 slots
        while(maxPQ.size() > 0){
            int k = n + 1;
            Set<Task> tempSet = new HashSet<>();
            
            while(k > 0 && maxPQ.size() > 0){
                Task task = maxPQ.poll();
                
                if(task.count > 1){
                    task.count = task.count -1;
                    tempSet.add(task);
                }
                time++;
                k--;
            }
            
            maxPQ.addAll(tempSet); // add valid tasks back to pq
            
            if(maxPQ.size() == 0) break;
            
            time += k; // if k > 0, the section are all filled with idle interval
        }
        
        return time;
        
        
    }
}

class Task {
    int ch;
    int count;
    
    Task(int ch, int count){
        this.ch = ch;
        this.count = count;
    }
}