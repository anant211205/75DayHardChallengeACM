class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length , maxEl = Integer.MIN_VALUE ; long ans = 0 ;
        int l = 0  , r = 0 ;
        HashMap<Integer , Integer> map = new HashMap<>() ;
        for(int i=0;i<n;i++){
            maxEl = Math.max(maxEl , nums[i]) ;
        }
        while(r<n){
            map.put(nums[r] , map.getOrDefault(nums[r] , 0)+1) ;
            while(map.getOrDefault(maxEl , 0)>=k){
                ans+=n-r ;
                map.put(nums[l] , map.get(nums[l])-1) ;
                l++;
            }
            r++ ;
        }
        return ans ;
    }
}