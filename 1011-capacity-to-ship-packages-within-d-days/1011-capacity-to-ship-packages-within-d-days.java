class Solution {
    public int shipWithinDays(int[] arr, int m) {

        int start = 0 ; int end = 0 ; int ans = 0 ;
        int n = arr.length ;

        for(int i=0;i<n;i++){
            start = Math.max(start, arr[i]) ;
            end += arr[i] ;
        }

        if(m>n) return -1 ;

        while(start<=end){

            int mid = start+(end-start)/2 ;

            int countStudents = 1 ; int pages = 0 ;

            // distributing pages to next student if pagescount > mid element
            for(int i=0;i<n;i++){
                pages+=arr[i] ;

                if(pages>mid){
                    countStudents++;
                    pages = arr[i];
                }
            }
            //where distribution is possible
            if(countStudents<=m){
                ans = mid ;
                end = mid - 1;
            }
            //distribution is not possible
            else{
                start = mid + 1;
            }

        }
        return ans;
    }
}