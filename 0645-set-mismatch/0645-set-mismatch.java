class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length ;

        HashMap<Integer , Integer> map = new HashMap<>() ;

        int[] ans = new int[2] ;

        for(int i = 0 ; i < n ; i++){

            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1) ;

            if(map.get(nums[i]) == 2){
                ans[0] = nums[i] ;
            }

        }


        for(int i = 1 ; i <= n ; i++){
            if(!map.containsKey(i)){
                ans[1] = i ;
                break ;
            }
        }

    return ans ;
    }
}