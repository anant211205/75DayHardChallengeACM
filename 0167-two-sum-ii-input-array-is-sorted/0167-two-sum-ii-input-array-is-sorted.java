class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length ;
        for(int i = 0 ; i < n ; i++){

            int num2 = target - numbers[i]; 
            int low = i + 1 , high = n - 1;

            while(low<=high){
                int mid = low + (high - low) / 2 ;

                if(numbers[mid] == num2) return new int[] {i + 1 , mid + 1} ;

                else if(numbers[mid] < num2) low = mid + 1 ;

                else high = mid - 1;
            }
        }

        return new int[]{}; 


        // int n = numbers.length ;
        // int low = 0 , high = n - 1;

        // while(low <= high){

        //     int mid = high + (low - high) / 2 ;

        //     if(numbers[low] + numbers[high] == target) return new int[] {low + 1 , high + 1} ;

        //     else if(numbers[low] + numbers[high] >= target){
        //         high = mid - 1;
        //     }
        //     else{
        //         low = mid + 1;
        //     }
        // }
        // return new int[] {low + 1 , high + 1} ;
    }
}