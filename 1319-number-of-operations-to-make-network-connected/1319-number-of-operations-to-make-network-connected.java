class Solution {
    public int find(int x , int []parent){
        if(x == parent[x]){
            return x ;
        }

        return parent[x] = find(parent[x] , parent) ;
    }

    public void union(int x , int y , int []rank , int[] parent){
        int x_parent = find(x , parent) ;
        int y_parent = find(y , parent) ;

        if(x_parent == y_parent) return ;

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent ;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent ;
        }else{
            parent[x_parent] = y_parent ;
            rank[y_parent] += 1 ;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length ;
        int []parent = new int[n] ;
        int []rank = new int[n]; 

        for(int i=0;i<n;i++){
            parent[i] = i ;
        }

        if(m < n-1) return -1 ;

        int components = n ;

        for(int []comp : connections){

            if(find(comp[0] , parent) != find(comp[1] , parent)){
                union(comp[0] , comp[1] , rank , parent) ;
                components-- ;
            }
        }
        return components - 1 ;
    }
}