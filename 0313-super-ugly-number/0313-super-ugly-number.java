class UglyNumber {
    int prime;
    int value;
    int index;
    
    public UglyNumber(int prime, int value, int index) {
        this.prime = prime;
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        PriorityQueue<UglyNumber> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        int[] uglyNums = new int[n+1];
                                  
        uglyNums[0] = -1;
        uglyNums[1] = 1;
                                  
        
        for(int i = 0; i < primes.length; i++) {
            pq.add(new UglyNumber(primes[i], primes[i] * uglyNums[1], 2));
        }
        
        int i = 2;
        while(i <= n) {
            UglyNumber u = pq.poll();
            
            //avoid duplicates
            if(u.value != uglyNums[i-1]) {
                uglyNums[i] = u.value;
                i++;
            }
            
            pq.add(new UglyNumber(u.prime, u.prime * uglyNums[u.index], u.index + 1));
        }
        
        return uglyNums[n];
    }
}