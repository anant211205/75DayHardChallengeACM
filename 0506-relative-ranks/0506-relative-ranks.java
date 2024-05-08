class Solution {
    public String[] findRelativeRanks(int[] score) {

        // further optimising it 
        int n = score.length ;
        int max = 0 ;
        for(int i=0;i<n;i++){
            max = Math.max(max , score[i]) ;
        }

        int []ranks = new int[max + 1] ;

        for(int i=0;i<n;i++){
            ranks[score[i]] = i + 1; 
        }
        int place = 1 ;
        String [] ans = new String[n] ;
        for(int i=max;i>=0;i--){
            if(ranks[i] == 0) continue ;
            int idx = ranks[i] - 1 ;
            if(place==1){
                ans[idx] = "Gold Medal" ;
            }else if(place == 2){
                ans[idx] = "Silver Medal" ;
            }else if(place == 3){
                ans[idx] = "Bronze Medal" ;
            }else{
                ans[idx] = String.valueOf(place) ;
            }
            place++ ;
        }

        return ans ;
        // tc -> o(nlogn)
        // int n = score.length ;
        // HashMap<Integer , Integer> map = new HashMap<>() ;
        // int[] arr = new int[n] ;
        // String []ans = new String[n] ;
        // for(int i=0;i<n;i++){
        //     arr[i] = score[i] ;
        // }
        // Arrays.sort(arr) ;
        // for (int i = n - 1; i >= 0; i--) {
        //     map.put(arr[i], n - i);
        // }

        // for(int i=0;i<n;i++){
        //     if(map.containsKey(score[i])){
        //         if(map.get(score[i]) == 1){
        //             ans[i] = "Gold Medal" ;
        //         }else if(map.get(score[i]) == 2){
        //             ans[i] = "Silver Medal" ;
        //         }else if(map.get(score[i]) == 3){
        //             ans[i] = "Bronze Medal" ;
        //         }else{
        //             ans[i] = map.get(score[i]).toString() ;
        //         }
        //     }
        // }
        // return ans ;
    }
}