class Solution {
    // public void helper(List<List<Integer>> result , List<Integer> list , int idx , int[] arr){
    //     result.add(new ArrayList<>(list)) ;

    //     for(int i = 0 ; i < arr.length ; i++){
    //         list.add(arr[i]) ;
    //         helper(result , list , idx + 1 , arr) ;
    //         list.remove(arr.length - 1) ;
    //     }
    // }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>() ;
        int n = nums.length ;
        int nOfSub = 1<<n ;
        for(int i=0;i<nOfSub ;i++){
            List<Integer> ls = new ArrayList<>() ;
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0)ls.add(nums[j]) ;
            }
            result.add(ls) ;
        }
        return result; 
        // helper(result , new ArrayList<>() , 0 , nums) ;
        // return result ;
    }
}