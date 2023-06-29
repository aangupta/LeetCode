class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] coins = new int[3];
        //0 index for $5
        //1 index for $10
        //2 index for $15
        
        for(int bill : bills){
            if(bill == 5){
                coins[0]++;
            }
            else if(bill == 10){
                if(coins[0] > 0){
                    coins[0]--;
                    coins[1]++;
                }
                else return false;
            }
            else if(bill == 20){
                if((coins[1]<=0 && coins[0] < 3) || (coins[1] > 0 && coins[0]<=0)){
                    return false;
                }
                
                if(coins[1]>0){
                    coins[1]--;
                    coins[0]--;
                }
                else {
                    coins[0] -=3;
                }
                    
            }
        }
        
        return true;
        
    }
}