class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0 ;
        for(int i : nums){
            xor ^= i ;
        }  
        // here -xor is 2's complement this will give thee first set bit
        int mask = ((xor) & (-xor)) ;
        
        int[] result = new int[2] ;
        for(int num : nums){
            if((mask & num) == 0){
                result[0] ^= num ;
            }else{
                result[1] ^= num ;
            }
        }
        return result ;
    }
}