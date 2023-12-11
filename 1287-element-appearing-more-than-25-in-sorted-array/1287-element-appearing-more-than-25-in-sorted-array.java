class Solution {
    public int findSpecialInteger(int[] arr) {
        int counter = 1 , element = arr[0] ;
        int n = arr.length , special = (n * 25)/100 ;
        
        for(int i = 1 ; i < n ; i++){
            if(element == arr[i]) counter++ ;
            else counter = 1 ;

            if(counter > special) return arr[i] ;

            element = arr[i] ;
        }
        
        return element ;

        // for(int i = 0 ; i < n - 1 ; i++){
        //     if(n == 1) return arr[i]; 
        //     for(int j = i + 1 ; j < n - 1 ; j++){
        //         if(arr[i] == arr[j]){
        //             counter++ ;
        //             if(counter > special){
        //                 element = arr[j] ;
        //                 break; 
        //             }else{
        //                 counter = 1 ;
        //                 element = arr[j] ;
        //             }
        //         }
        //     }
        // }
        // if(arr[n - 1] == arr[n - 2] && counter > special) element = arr[n - 1] ;
        // return element ;
    }
}