import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //optimal solution

        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<>();
        Arrays.sort(nums);
        int second, third, n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue ;
            second = i + 1;
            third = n - 1;
            while (second < third) {
            int sum = nums[i] + nums[second] + nums[third];
                if (sum == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[second], nums[third]);
                    st.add(temp);
                    second++ ;
                    third-- ;
                } else if (sum < 0)
                    second++;
                else
                    third--;
            }
        }
        for (List<Integer> i : st) {
            ans.add(i);
        }
        return ans;


        //Better solution
        // HashSet<List<Integer>> st = new HashSet<>() ;
        // int n = nums.length ;
        // for(int i = 0 ; i < n ; i++){
        //     HashSet<Integer> set = new HashSet<>() ;
        //     for(int j = i + 1 ; j < n ; j++){
                
        //         int third = -(nums[i] + nums[j]) ;

        //         if(set.contains(third)){
        //             List<Integer> ls = Arrays.asList(nums[i] , nums[j] , third) ;
        //             ls.sort(null) ;
        //             st.add(ls) ;
        //         }
        //         else{
        //             set.add(nums[j]) ;
        //         }
        //     }
        // }

        
        


        //brute force
        // int n = nums.length ;
        // Set<List<Integer>> st = new HashSet<>() ;
        // for(int i = 0 ; i < n ; i++){
        // for(int j = i + 1 ; j < n ; j++){
        // for(int k = j + 1 ; k < n ; k++){
        // if((nums[i] + nums[j] + nums[k]) == 0){
        // List<Integer> temp = Arrays.asList(nums[i] , nums[j] , nums[k]);
        // temp.sort(null);
        // st.add(temp);
        // }
        // }
        // }
        // }
        // List<List<Integer>> ans = new ArrayList<>(st) ;
        // return ans ;
    }
}