class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length ;
        int start = 0 ; int end = n - 1 ;
        int ans = n ; int mid ;

        while(start <= end){

            mid = start + (end - start) / 2 ;

            if(arr[mid] - mid - 1 >= k){
                ans = mid ;
                end = mid - 1 ;
            }
            else{
                start = mid + 1;
            }
        }
        return ans + k ;
    }
}