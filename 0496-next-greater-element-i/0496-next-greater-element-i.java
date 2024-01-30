class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // optimised

        HashMap<Integer , Integer> map = new HashMap<>() ;
        Stack<Integer> st = new Stack<>() ;

        for(int i = 0 ; i < nums2.length ; i++){

            while(!st.isEmpty() && st.peek() < nums2[i]){

                map.put(st.pop() , nums2[i]) ;

            }

            st.push(nums2[i]);

        }

        for(int i = 0 ; i < nums1.length ;  i++){

            nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1 ;

        }

        return nums1 ;


        //brute force
        // int n = nums1.length , m = nums2.length ;

        // int[] arr = new int[nums1.length] ;

        // for(int i = 0 ; i < n ; i++){
        //     int max = -1 ;

        //     for(int j = 0 ; j < m ; j++){

        //         int index = j ;

        //         if(nums1[i] == nums2[j]){

        //             while(index != m){
        //                 if(nums2[index] > nums1[i]){
        //                     max = nums2[index] ;
        //                     break ;
        //                 }
        //                 index++ ;
        //             }
        //         } 
        //     }
        //     arr[i] = max ;
        // }   
        // return arr ;
    }
}