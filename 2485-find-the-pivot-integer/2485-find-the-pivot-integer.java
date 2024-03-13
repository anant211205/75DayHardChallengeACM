class Solution {
    public int pivotInteger(int n) {
        int start = 1 , end = n ;
        int total = n*(n+1)/2 ;
        while(start <= end){
            int mid = start+(end-start)/2 ;
            int stSum = mid*(mid+1)/2; 
            int endSum = total - stSum + mid ;
            if(stSum == endSum) return mid ;
            else if(stSum > endSum) end = mid-1;
            else start = mid+1;
        }
        return -1 ;
    }
}