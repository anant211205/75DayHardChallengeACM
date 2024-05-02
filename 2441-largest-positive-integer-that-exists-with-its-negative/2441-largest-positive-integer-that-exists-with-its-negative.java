class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length ;
        HashMap<Integer , Integer> map = new HashMap<>();
    
        for(int i=0;i<n;i++){
            if(nums[i] < 0){
                map.put(nums[i] , 1) ;
            }
        }
        int max = -1 ;
        for(int i=0;i<n;i++){
            if(nums[i] > 0 && map.get(-(nums[i])) != null && map.get(-(nums[i])) == 1){
                max = Math.max(max , nums[i]) ;
            }
        }
        return max ;

        ///
        // int res = -1;
        // Set<Integer> numSet = new HashSet<>();
        // for (int num : nums) {
        //     numSet.add(num);
        // }
        // for (int num : numSet) {
        //     if (numSet.contains(-num)) {
        //         res = Math.max(res, num);
        //     }
        // }
        // return res;
    }
}