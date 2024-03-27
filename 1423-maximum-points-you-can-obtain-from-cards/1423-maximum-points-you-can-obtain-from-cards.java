class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int rSum = 0 , lSum = 0 , maxSum = 0 ;
        for(int i=0;i<k;i++){
            lSum+=cardPoints[i];
        }
        maxSum = lSum ;
        for(int i=0;i<k;i++){
            lSum-=cardPoints[k-i-1];
            rSum+=cardPoints[n-1-i];
            maxSum = Math.max(maxSum , lSum+rSum) ;
        }
        return maxSum ;
    }
}