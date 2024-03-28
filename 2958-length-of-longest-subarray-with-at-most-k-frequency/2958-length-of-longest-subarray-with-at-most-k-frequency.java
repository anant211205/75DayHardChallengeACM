class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length ;
        HashMap<Integer , Integer> map = new HashMap<>() ;
        int l = 0 , r = 0 ;
        int maxLen = 0 ;
        while(r<n){
            map.put(nums[r] , map.getOrDefault(nums[r] , 0)+1) ;
            while(map.get(nums[r])>k){
                map.put(nums[l] , map.get(nums[l])-1) ;
                l++ ;
            }
            if(map.get(nums[r])<=k)maxLen = Math.max(maxLen , r-l+1) ;
            r++; 
        }
        return maxLen ;
    }
}