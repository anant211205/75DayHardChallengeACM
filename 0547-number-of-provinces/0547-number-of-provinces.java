class Solution {

    public void dfs(int node , int[][] adj , boolean []vis){
        int n = adj.length ;
        vis[node] = true ;

        for(int i=0;i<n;i++){
            if(!vis[i] && adj[i][node]==1){
                dfs(i , adj , vis) ;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length ;
        // ArrayList<Integer>[] adj = new ArrayList[n] ;
        int count = 0 ;
        boolean []vis = new boolean[n]; 

        //creating adjacency list
        // for (int i = 0; i < n; i++) {
        //     adj[i] = new ArrayList<>();
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(isConnected[i][j] == 1){
        //             adj[i].add(j) ;
        //             adj[j].add(i) ;
        //         }
        //     }
        // }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i , isConnected , vis) ;
                count++ ;
            }
        }
        return count ;
    }
}