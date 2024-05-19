class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges){
        //Approach 2  tc->o(nlogn) sp -> o(n)

        // ArrayList<Integer> ls = new ArrayList<>() ;
        // long sum = 0 ;

        // for(int num : nums){
        //     ls.add((num^k) - num) ;
        //     sum += (long)(num) ;
        // }

        // Collections.sort(ls , Collections.reverseOrder()) ;

        // for(int i=0;i<ls.size()-1;i+=2){
        //     long pairSum = ls.get(i) + ls.get(i+1) ;
        //     if(pairSum > 0){
        //         sum += pairSum ;
        //     }
        // }

        // return sum ;
 
        //Approach 1 tc->o(n) sp-> o(1)
        long sum = 0 ;
        int count = 0 ;
        long minNuksan = Long.MAX_VALUE ;

        for(long num : nums){
            if((num ^ k) > num){
                count++ ;
                sum += (num ^ k) ;
            }else{
                sum += num ;
            }

            minNuksan = Math.min(minNuksan , Math.abs(num - (num^k))) ;
        }

        if((count&1)==0){
            return sum ;
        }
        return sum - minNuksan; 
        
    }
}