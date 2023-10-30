class Solution {
    public void swap(int nums[] , int i , int correct){
        int temp = nums[i] ;
        nums[i] = nums[correct];
        nums[correct] = temp ;
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length ;
        int i = 0 ;
        while(i < n){
            if(nums[i] != i + 1){
                int correct = nums[i] - 1 ;
                if(nums[i] != nums[correct]){
                    swap(nums , i , correct);
                }else{
                    return nums[i];
                }
            }else{
                i++ ;
            }
        }
        return -1 ;
        // int n = nums.length  ;
        // int element = 0 ;
        // int count = 0 ;
        // for(int i = 0 ; i < n ; i++){
        //     if(count == 0){
        //         element = nums[i] ;
        //         count = 1 ; 
        //     }else if(nums[i] == element){
        //         count++ ;
        //     }else{
        //         count = 0 ;
        //     }
        // }
        // if(count > 2){
        //     return element ;
        // }
        // return element ;
    }
}