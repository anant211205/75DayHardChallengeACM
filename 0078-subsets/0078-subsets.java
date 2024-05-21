class Solution {
    private List<List<Integer>> result = new ArrayList<>() ;
    // public void helper(List<List<Integer>> result , List<Integer> list , int idx , int[] arr){
    //     result.add(new ArrayList<>(list)) ;

    //     for(int i = 0 ; i < arr.length ; i++){
    //         list.add(arr[i]) ;
    //         helper(result , list , idx + 1 , arr) ;
    //         list.remove(arr.length - 1) ;
    //     }
    // }

    public void solve(int[]nums , List<Integer> ls , int idx){
        if(idx >= nums.length){
            result.add(new ArrayList<>(ls)) ;
            return ;
        }

        ls.add(nums[idx]) ;
        solve(nums , ls , idx + 1) ;
        ls.remove(ls.size() - 1) ;
        solve(nums , ls , idx + 1) ;

    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length ;
        List<Integer> ls = new ArrayList<>(); 
        solve(nums , ls , 0) ;
        return result ;
        // int nOfSub = 1<<n ;
        // for(int i=0;i<nOfSub ;i++){
        //     List<Integer> ls = new ArrayList<>() ;
        //     for(int j=0;j<n;j++){
        //         if((i&(1<<j))!=0)ls.add(nums[j]) ;
        //     }
        //     result.add(ls) ;
        // }
        // return result; 
        // helper(result , new ArrayList<>() , 0 , nums) ;
        // return result ;
    }
}