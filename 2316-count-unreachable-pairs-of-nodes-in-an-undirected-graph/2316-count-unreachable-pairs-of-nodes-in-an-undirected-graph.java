class Solution {
    public int find(int x , int[]parent){
        if(x == parent[x]){
            return x ;
        }
        return parent[x] = find(parent[x] , parent) ;
    }

    public void union(int x ,int y , int[]parent , int[] rank){
        int x_parent = find(x , parent) ;
        int y_parent = find(y , parent) ;

        if(x_parent == y_parent) return ; 

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent ;
        }
        else if(rank[y_parent] > rank[x_parent]){
            parent[x_parent] = y_parent ;
        }
        else{
            parent[x_parent] = y_parent ;
            rank[y_parent] += 1 ;
        }
    }

    public long countPairs(int n, int[][] edges) {
        int m = edges.length ;
        int[]parent = new int[n] ;
        int[]rank = new int[n] ;
        HashMap<Integer , Integer> map = new HashMap<>() ;
        
        for(int i=0;i<n;i++){
            parent[i] = i ;
        }

        for(int []e : edges){
            union(e[0] , e[1] , parent , rank) ;
        }

        for(int i=0;i<n;i++){
            map.put(find(i , parent)  , map.getOrDefault(find(i , parent) , 0) + 1) ;
        }

        long nodesRem = n ;
        long result = 0 ;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            int size = entry.getValue() ;
            result += size * (nodesRem - size) ;
            nodesRem -= size ;
            
        }

        return result ;
    }
}