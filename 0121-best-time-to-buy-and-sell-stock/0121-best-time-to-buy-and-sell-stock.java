import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        //brute force 

        // int maxProfit = 0 ;
        // int n = prices.length ;
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i + 1 ; j < n ; j++){
        //         if(prices[j] > prices[i]){
        //             maxProfit = Math.max(prices[j] - prices[i] , maxProfit) ;
        //         }
        //     }
        // }
        // return maxProfit ;

        // optimal approach
        int n = prices.length ;
        int minPrice = Integer.MAX_VALUE ;
        int maxProfit = 0 ;
        for(int i = 0 ; i < n ; i++){
            minPrice = Math.min(minPrice , prices[i]);
            maxProfit = Math.max(maxProfit , prices[i] - minPrice);
        }
        return maxProfit ;
    }
}