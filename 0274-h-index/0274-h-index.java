class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length ;
        //storing the no of papers in another array
        int[] arr = new int[n+1] ;
        for(int i=0;i<n;i++){
            arr[Math.min(citations[i], n)]++;
        }
        int count = 0 ;
        //total count should be 
        for(int i=arr.length-1;i>=0;i--){
            count+=arr[i] ;
            if(count >= i){
                return i ;
            }
        }
        return 0 ;
    }
}