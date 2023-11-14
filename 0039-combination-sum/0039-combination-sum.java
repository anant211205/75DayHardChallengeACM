class Solution {
    public void findCombinations(int idx , int[] arr , List<List<Integer>> ans , int target , List<Integer> ds){
        if(idx == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return ;
        }
        
        if(arr[idx] <= target){
            ds.add(arr[idx]) ;
            findCombinations(idx , arr , ans , target - arr[idx] , ds) ;
            ds.remove(ds.size() - 1) ;
        }
        findCombinations(idx + 1 , arr , ans , target , ds) ;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>() ;
        findCombinations(0 , candidates , ans , target , new ArrayList<>()) ;
        return ans ;
    }
}