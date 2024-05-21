class Solution {
    private List<List<Integer>> result = new ArrayList<>() ;
    private int n ; 

    public void swap(int []nums , int i , int idx){
        int temp = nums[i] ;
        nums[i] = nums[idx] ;
        nums[idx] = temp ;
    }

    public void solve(List<Integer> ls , HashMap<Integer , Integer> map){
        if(ls.size() == n){
            result.add(new ArrayList<>(ls)) ;
            return  ;
        }

        for(Map.Entry<Integer , Integer> entry : map.entrySet()){

            int key = entry.getKey();
            int value = entry.getValue();

            if(value == 0){
                continue; 
            }

            ls.add(key) ;
            map.put(key , value - 1) ;

            solve(ls , map) ;

            ls.remove(ls.size() - 1) ;
            map.put(key , value) ;

        }

    }

    public void solve2(int[] nums , int idx){
        if(idx == n){
            List<Integer> ls = new ArrayList<>() ;
            for(int num : nums){
                ls.add(num) ;
            }
            result.add(ls) ;
            return  ;
        }

        HashSet<Integer> set = new HashSet<>() ;

        for(int i=idx ;i<n;i++){
            if(set.contains(nums[i])){
                continue ;
            }

            set.add(nums[i]) ;
            swap(nums , i , idx) ;

            solve2(nums , idx + 1) ;

            swap(nums , i , idx) ;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length ;
        // HashMap<Integer , Integer> map = new HashMap<>() ;
        List<Integer> ls = new ArrayList<>() ;

        // for(int i=0;i<n;i++){
        //     map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1) ;
        // }

        solve2(nums , 0) ;
        return result ;

    }
}