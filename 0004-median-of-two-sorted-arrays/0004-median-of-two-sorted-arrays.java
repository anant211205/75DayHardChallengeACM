class Solution {
    // public static int[] mergeArr(int[] arr1 , int[] arr2){
    //     int n1 = arr1.length , n2 = arr2.length , n3 = n1 + n2 ;
    //     int[] arr3 = new int[n3] ;
    //     int i , j , k ;
        
    //     i = j = k = 0 ;

    //     while(i < n1 && j < n2){
    //         if(arr1[i] < arr2[j]){
    //             arr3[k++] = arr1[i++] ;
    //         }
    //         else{
    //             arr3[k++] = arr2[j++] ;
    //         }
    //     }

    //     while(i < n1 ){
    //         arr3[k++] = arr1[i++] ;
    //     }

    //     while(j < n2){
    //         arr3[k++] = arr2[j++] ;
    //     }

    //     return arr3 ;
    // }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // int[] newArr = mergeArr(nums1 , nums2) ;
        // int n = newArr.length ;

        // if(n % 2 == 0) return (double)(newArr[n / 2] + newArr[n / 2 - 1]) / 2 ;
        
        // else return (double)(newArr[n / 2]) ; 


        int n1 = nums1.length , n2 = nums2.length ;
        if(n1 > n2) return findMedianSortedArrays(nums2 , nums1) ;
        int n = n1 + n2 ;
        int low = 0 , high = n1 ;
        int left = (n1 + n2 + 1) / 2 ;
        while(low <= high){
            int mid1 = (low + high) / 2 ;
            int mid2 = left - mid1 ;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1] ;
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1] ;
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1] ;
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2] ;

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 0) return (double)(Math.max(l1 , l2) + Math.min(r1 , r2)) / 2.0 ;
                else return (double) Math.max(l1 , l2) ;
            }
            
            else if(l1 > r2) high = mid1 - 1; 

            else low = mid1 + 1 ;
        }
        return 0.0 ;
    }
}