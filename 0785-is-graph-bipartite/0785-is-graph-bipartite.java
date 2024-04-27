class Solution {

    public boolean checkBFS(int[][] adj , int node , int []color , int currColor){
        Queue<Integer> que = new LinkedList<>();
        que.add(node) ;
        color[node] = currColor ;

        while(!que.isEmpty()){
            int u = que.poll() ;

            for(int v : adj[u]){ // Iterate over indices of adj[u]
                if(color[v] == color[u]){
                    return false ;
                }else if(color[v] == -1){
                    color[v] = 1 - color[u];
                    que.add(v) ;
                }
            }
        }
        return true ;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length ;
        int []color = new int[n] ;
        Arrays.fill(color , -1) ;
        // ArrayList<Integer>[] adj = new ArrayList[n] ;
        // for(int i=0;i<n;i++){
        //     adj[i] = new ArrayList<>() ;
        //     for(int j : graph[i]){
        //         adj[i].add(j) ;
        //     }
        // }


        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(!checkBFS(graph , i , color , 1)){
                    return false ;
                }
            } 
        }
        return true ;
    }
}