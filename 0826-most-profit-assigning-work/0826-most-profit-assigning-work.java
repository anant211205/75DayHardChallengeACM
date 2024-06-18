class Pair{
    int first , second ;
    Pair(int first , int second){
        this.first = first ;
        this.second = second ;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length ;
        int m = worker.length ;

        //Approach 3

        // two pointer

        List<Pair> ls = new ArrayList<>(); 
        for(int i=0;i<n;i++){
            ls.add(new Pair(difficulty[i] , profit[i])) ;
        }

        Collections.sort(ls , (a, b) -> Integer.compare(a.first, b.first)) ;

        Arrays.sort(worker) ;

        int j = 0 ; // pointing to ls ;

        int total = 0 ;
        int max = 0 ;

        for(int i=0;i<m;i++){

            while(j < n && worker[i] >= ls.get(j).first){
                max = Math.max(max , ls.get(j).second) ;
                j++ ;
            }
            total += max; 
        }

        return total ;

        //approach 2 .. using binary search 

        // List<Pair> ls = new ArrayList<>(); 
        // for(int i=0;i<n;i++){
        //     ls.add(new Pair(difficulty[i] , profit[i])) ;
        // }

        // Collections.sort(ls , (a, b) -> Integer.compare(a.first, b.first)) ;

        // for(int i=1;i<ls.size();i++){
        //     ls.get(i).second = Math.max(ls.get(i-1).second , ls.get(i).second) ; 
        // }

        // int totalProfit = 0 ;

        // for(int i=0;i<m;i++){

        //     int workerLevel = worker[i] ;
        //     int low = 0 , high = ls.size() - 1 ;
        //     int maxProfit = 0 ;

        //     while(low <= high){

        //         int mid = low + (high - low) / 2; 

        //         if(ls.get(mid).first <= workerLevel){

        //             maxProfit = Math.max(maxProfit , ls.get(mid).second) ;

        //             low = mid + 1 ;

        //         }else{

        //             high = mid - 1 ;
        //         }

            
        //     }

        //     totalProfit += maxProfit; 
        // }

        // return totalProfit; 



        //approach 1 // using heap
        // int ans = 0 ;
        // PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> (b.second-a.second));
        // for(int i=0;i<n;i++){
        //     int diffi = difficulty[i]; 
        //     int pro = profit[i] ;

        //     pq.add(new Pair(diffi , pro)) ;
        // }

        // int i = 0 ; int j = m - 1;
        // Arrays.sort(worker) ;
        // while(i < j){
        //     int temp = worker[i] ;
        //     worker[i] = worker[j] ;
        //     worker[j] = temp ;
        //     i++ ;
        //     j-- ;
        // }
        // i = 0;
        // while(i < m && !pq.isEmpty()){
        //     Pair p = pq.peek() ;
        //     if(p.first > worker[i]){
        //         pq.poll() ;
        //     }else{
        //         ans += p.second ;
        //         i++ ;
        //     }
        // }
        // return ans ;
    }
}