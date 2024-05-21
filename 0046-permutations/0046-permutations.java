class Solution {

    private List<List<Integer>> result = new ArrayList<>() ;

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void solve2(int[]nums , int idx){
        if(idx == nums.length){
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return ;
        }

        for(int i=idx;i<nums.length;i++){
            swap(nums , i , idx) ;
            solve2(nums , idx + 1); 
            swap(nums , i , idx) ;
        }
    }

    // public void solve(int[]nums , List<Integer> ls , boolean []used){
    //     if(ls.size() == nums.length){
    //         result.add(new ArrayList<>(ls)) ;
    //         return ;
    //     }

    //     for(int i=0;i<nums.length;i++){
    //         if(!used[i]){
    //             ls.add(nums[i]) ;
    //             used[i] = true ;
    //             solve(nums , ls , used) ;
    //             ls.remove(ls.size() - 1) ;
    //            used[i] = false ;
    //         }
    //     }   
    // }

    public List<List<Integer>> permute(int[] nums) {
        // List<Integer> ls = new ArrayList<>() ;
        // boolean [] used = new boolean[nums.length]; 
        solve2(nums , 0) ;
        return result ;
    }
}