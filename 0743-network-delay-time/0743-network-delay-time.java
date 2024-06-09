class Solution {

class Pair{
    int node , dis ;

    Pair(int node , int dis){
        this.node = node ;
        this.dis = dis ;
    }
    
}

    public int networkDelayTime(int[][] times, int n, int S) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>() ;
        for(int i=0;i<n ;i++){
            adj.add(new ArrayList<>()) ;
        }   

        for(int []ar : times){
            int a = ar[0] - 1 ;
            int b = ar[1] - 1 ;
            int c = ar[2] ;
            ArrayList<Integer> ls = new ArrayList<>() ;
            ls.add(b) ;
            ls.add(c) ;
            adj.get(a).add(ls) ;
        }

        int [] dist = new int[n] ;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x , y) -> x.dis - y.dis) ;
        for(int i=0;i<dist.length ;i++) dist[i] = Integer.MAX_VALUE;
        dist[S-1] = 0 ;
        pq.add(new Pair(S-1 , 0)) ;
        
        while(!pq.isEmpty()){
            
            Pair p = pq.poll() ;
            int ni = p.node ;
            int d = p.dis ;
            
            for(ArrayList<Integer> ls : adj.get(ni)){
                int no = ls.get(0) ;
                int di = ls.get(1) ;
                if(di + d < dist[no]){
                    dist[no] = di + d ;
                    pq.add(new Pair(no , dist[no])) ;
                }
            }
            
        }
        
        int ans = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}