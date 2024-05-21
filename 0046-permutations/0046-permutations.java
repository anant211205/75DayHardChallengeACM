class Solution {

    private List<List<Integer>> result = new ArrayList<>() ;

    public void solve(int[]nums , List<Integer> ls , boolean []used){
        if(ls.size() == nums.length){
            result.add(new ArrayList<>(ls)) ;
            return ;
        }

        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                ls.add(nums[i]) ;
                used[i] = true ;
                solve(nums , ls , used) ;
                ls.remove(ls.size() - 1) ;
               used[i] = false ;
            }
        }   
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ls = new ArrayList<>() ;
        boolean [] used = new boolean[nums.length]; 
        solve(nums , ls , used) ;
        return result ;
    }
}