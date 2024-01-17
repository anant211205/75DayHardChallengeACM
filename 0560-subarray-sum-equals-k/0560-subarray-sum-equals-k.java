class Solution {
    public int subarraySum(int[] nums, int k) {

        //optimal approach

        HashMap<Integer , Integer> map = new HashMap<>() ;

        int count = 0 , prefixSum = 0 ; 

        map.put(0 , 1) ;

        int n = nums.length ;

        for(int i = 0 ; i < n ; i++){

            prefixSum += nums[i]; 

            if(map.containsKey(prefixSum - k)){

                count += map.get(prefixSum - k) ;

            }
            map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1) ;
        }
        
        return count ; 
        // Brute Force
        // int n = nums.length ;
        // int count = 0 ;
        // for(int i = 0 ; i < n ; i++){
        //     int sum = 0 ;
        //     for(int j = i ; j < n ; j++){
        //         sum += nums[j] ; 
        //         if(sum == k){
        //             count++ ;
        //         }
        //     }
        // }
        // return count ;
    }
}