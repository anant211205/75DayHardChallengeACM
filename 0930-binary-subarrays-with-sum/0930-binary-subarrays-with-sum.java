class Solution {

    // for sum <= goal 
    public int helper(int[] nums , int goal){
        if(goal<0)return 0 ;
        int n = nums.length ;
        int ans = 0 , sum = 0 ;
        int l = 0 , r = 0 ;
        while(r<n){
            sum+=nums[r] ;
            while(sum>goal && l<=r){
                sum-=nums[l];
                l++;
            }
            ans+=r-l+1 ;
            r++;
        }
        return ans ;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {

        // more optimisation
        // sum <= goal - sum <= goal-1 will give sum == goal
        if(goal<0) return 0 ;
        return helper(nums , goal) - helper(nums , goal-1) ;


        //tc:O(N) sc :O(N)
        // int n = nums.length ;
        // int count = 0 , sum = 0 ;
        // HashMap<Integer ,Integer> map = new HashMap<>();

        // map.put(0 , 1) ;

        // for(int i=0;i<n;i++){
        //     sum+=nums[i]; 

        //     int rem = sum - goal ;
            
        //     if(map.containsKey(rem)){
        //         count+= map.get(rem) ;
        //     }

        //     map.put(sum , map.getOrDefault(sum , 0) +1) ;
        // }
        // return count ;
    }
}