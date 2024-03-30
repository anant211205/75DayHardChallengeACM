class Solution {
    public int subarryAtmostK(int[]nums , int k){
        int n = nums.length ;
        int l = 0 , r =  0 , ans = 0 ;
        HashMap<Integer , Integer> map = new HashMap<>() ;
        while(r<n){
            map.put(nums[r] , map.getOrDefault(nums[r] , 0) + 1) ;
            while(map.size() > k){
                map.put(nums[l] , map.get(nums[l])-1) ;
                if(map.get(nums[l])==0){
                    map.remove(nums[l]) ;
                }
                l++ ;
            }
            ans += (r - l + 1);
            r++ ;
        }
        return ans ;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarryAtmostK(nums , k) - subarryAtmostK(nums , k-1) ;
    }
}