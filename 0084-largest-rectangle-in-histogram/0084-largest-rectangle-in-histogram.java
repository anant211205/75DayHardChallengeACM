class Solution {

    // public static int[] NseR(int[] arr){
    //     Stack<Integer> st = new Stack<>() ;
    //     int n = arr.length ;
    //     int [] ans = new int[n] ;
    //     for(int i = 0 ; i < n ; i++){

    //         while(!st.isEmpty() && arr[st.peek()] > arr[i]){
    //             ans[st.peek()] = i ;
    //             st.pop() ;
    //         }
    //         st.push(i) ;
    //     }

    //     while(!st.isEmpty()){
    //         ans[st.peek()] = n ;
    //         st.pop() ;
    //     }

    //     return ans ;
    // }

    // public  static int[] NseL(int[] arr){
    //     Stack<Integer> st = new Stack<>() ;
    //     int n = arr.length ;
    //     int [] ans = new int[n] ;
    //     for(int i = n - 1 ; i >= 0 ; i--){
    //         while(!st.isEmpty() && arr[st.peek()] > arr[i]){
    //             ans[st.peek()] = i ;
    //             st.pop() ;
    //         }
    //         st.push(i) ;
    //     }

    //     while(!st.isEmpty()){
    //         ans[st.peek()] = -1 ;
    //         st.pop() ;
    //     }

    //     return ans ;
    // }

    public int largestRectangleArea(int[] heights) {

        // more optimised

        int n = heights.length ;
        int index = 0 ;
        Stack<Integer> st = new Stack<>() ;
        int ans = Integer.MIN_VALUE ;

        for(int i = 0 ; i < n ; i++){

            while(!st.isEmpty() && heights[st.peek()] > heights[i]){

                index = st.peek() ;
                st.pop() ;

                if(!st.isEmpty()) ans = Math.max(ans, heights[index] * (i - st.peek() - 1)) ;
                else ans = Math.max(ans ,heights[index] * i) ;
            
            }
            st.push(i) ;
        }

        while(!st.isEmpty()){
            index = st.peek() ;
            st.pop() ;

            if(!st.isEmpty()) ans = Math.max(ans, heights[index] * (n - st.peek() - 1)) ;
            else ans = Math.max(ans ,heights[index] * n) ;

        }

        return ans ;


        // int [] nsl = NseL(heights) ;
        // int [] nsr = NseR(heights) ;
        // int max = Integer.MIN_VALUE ;
        // int result = 0 ;
        // for(int i = 0 ; i < heights.length ; i++){
        //     result = heights[i] * (nsr[i] - nsl[i] - 1) ;
        //     max = Math.max(max , result);
        // }
        // return max ;
    }
}