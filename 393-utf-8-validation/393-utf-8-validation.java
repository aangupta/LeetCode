class Solution {
    
        /*If we encounter an integer whose last 8 bits look like this. (Where x represents any number.) we need to perform the following operations.

    data[i] = 0 X X X X X X X -> Move to next element in array.

    data[i] = 1 1 0 X X X X X -> Next element in array should be equal to 1 0 X X X X X X.

    data[i] = 1 1 1 0 X X X X -> Next two element in array should be equal to 1 0 X X X X X X.

    data[i] = 1 1 1 1 0 X X X -> Next three element in array should be equal to 1 0 X X X X X X.

    If the array satiesfeis all these condition then only return true or else return false*/
    public boolean validUtf8(int[] data) {
        
        int remain = 0;
        for(Integer val : data)
        {
            if(remain == 0)
            {
                if(val>>7 == 0b0)            
                {
                    remain = 0;
                }
                else if(val>>5 == 0b110)
                {
                    remain = 1;
                }
                else if(val>>4 == 0b1110)
                {
                    remain = 2;
                }
                else if(val>>3 == 0b11110)
                {
                    remain = 3;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(val>>6 == 0b10)
                {
                    remain--;
                }
                else
                {
                    return false;
                }
            }        
        }      
        return remain == 0;
    }
        
    
}