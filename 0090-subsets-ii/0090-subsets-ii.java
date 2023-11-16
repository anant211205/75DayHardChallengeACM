import java.util.* ;
class Solution {

    public static void findSubset(int idx , int[] arr , List<Integer> ds , List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds)) ;
        for(int i = idx ; i < arr.length ; i++){
            if(i != idx && arr[i] == arr[i - 1]) continue ;

            ds.add(arr[i]) ;
            findSubset(i + 1 , arr , ds , ans) ;
            ds.remove(ds.size() - 1) ;
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums) ;
        List<List<Integer>> ansList = new ArrayList<>() ;
        findSubset(0 , nums , new ArrayList<>() , ansList) ;
        return ansList ;
    }
}