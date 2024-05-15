class Solution {
    public int find(int x , int []parent){
        if(x == parent[x]) return x ;
        return parent[x] = find(parent[x] , parent) ;
    }

    public void union(int x , int y , int[] parent , int[]rank){
        int x_parent = find(x , parent) ;
        int y_parent = find(y , parent) ;

        if(x_parent == y_parent){
            return ;
        }

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent ;
        }
        else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent ;
        }
        else{
            parent[x_parent] = y_parent ;
            rank[y_parent] += 1 ;
        }

    }
    public int[] findRedundantConnection(int[][] edge) {
        int n = edge.length ;
        int []parent = new int[n+1] ;
        int []rank = new int[n+1] ;

        for(int i=0;i<=n;i++){
            parent[i] = i; 
        }

        for(int [] ar : edge){
            if(find(ar[0] , parent) == find(ar[1] , parent)){
                return new int[] {ar[0] , ar[1]} ;
            }else{
                union(ar[0] , ar[1] , parent , rank) ;
            }
        }
        return new int[]{-1 , -1} ;
    }
}