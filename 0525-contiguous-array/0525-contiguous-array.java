class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length ;
        int maxLen = 0 ;
        int pSum = 0 ;
        for(int i=0;i<n;i++){
            if(nums[i]==0) nums[i] = -1 ;
        }

        HashMap<Integer , Integer> hm = new HashMap<>() ;

        for(int i=0;i<n;i++){
            pSum+=nums[i] ;

            if(pSum == 0){
                maxLen = Math.max(maxLen , i+1) ;
            }
            int rem = pSum - 0 ;

            if(hm.containsKey(rem)) maxLen = Math.max(maxLen , i - hm.get(rem)) ;

            if(!hm.containsKey(pSum)) hm.put(pSum , i) ;
        }
        return maxLen ;
    }
}