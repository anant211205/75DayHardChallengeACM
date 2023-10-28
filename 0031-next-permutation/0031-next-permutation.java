import java.util.* ;
class Solution {
    public void swap(int nums[] , int a , int b){
        int temp = nums[a] ;
        nums[a] = nums[b] ;
        nums[b] = temp ;
    }
    public void reverseArr(int nums[] , int idx){
        int left = idx;
        int right = nums.length - 1 ;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        int idx = -1 ;
        int n = nums.length ;
        for(int i = n - 2 ; i >= 0 ; i--){   //longest prefix match (a[i] < a[i+1])
            if(nums[i] < nums[i + 1]) {
                idx = i ;
                break ;
            }
        }
        if(idx == -1){             //if array is 
            reverseArr(nums , 0);     
            return ;
        }

        for(int i = n - 1 ; i >= idx ; i--){          // finding element which is > indexed no. but the smallest 1
            if(nums[i] > nums[idx]){
                swap(nums , i , idx) ;
                break ;
            }
        }
        reverseArr(nums , idx + 1);    //sort array after index 
    }
}