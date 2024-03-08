class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer , Integer> hm = new HashMap<>() ;
        int n = nums.length ;
        for(int i=0;i<n;i++){
            hm.put(nums[i] , hm.getOrDefault(nums[i] , 0) + 1) ;
        }
        int max = Integer.MIN_VALUE ;
        for(int freq : hm.values()){
            max = Math.max(max , freq) ;
        }
        int count = 0 ;
        for(int i : hm.values()){
            if(i == max) count+=max ;
        }
        return count ;
    }
}