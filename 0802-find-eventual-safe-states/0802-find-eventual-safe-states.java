class Solution {

    public boolean inCycle(int[][] adj , int u , boolean[]vis , boolean[] inRec){
        vis[u] = true ;
        inRec[u] = true ;

        for(int v : adj[u]){
            if(!vis[v] && inCycle(adj , v , vis , inRec)){
                return true ;
            }else if(inRec[v]){
                return true ;
            }
        }
        inRec[u] = false ;
        return false; 
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        //BFS
        int n = graph.length ;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        Queue<Integer> q = new LinkedList<>() ;
        int[] indegree = new int[n];
        boolean []safe = new boolean[n] ;
        ArrayList<Integer> ans = new ArrayList<>() ;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>()) ;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i) ;
            }
        }

        while(!q.isEmpty()){
            int p = q.poll() ;
            safe[p] = true ;

            for(int v : adj.get(p)){
                indegree[v]-- ;
                if(indegree[v] == 0){
                    q.add(v) ;
                    safe[v] = true ;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(safe[i]){
                ans.add(i) ;
            }
        }

        return ans ;
        //DFS
        // int n = graph.length ;
        // boolean[]vis = new boolean[n] ;
        // boolean[]inRec = new boolean[n] ;
        // List<Integer> ans = new ArrayList<>() ;

        // for(int i=0;i<n;i++){
        //     if(!vis[i]){
        //         inCycle(graph , i , vis , inRec) ;
        //     }
        // }

        // for(int i=0;i<n;i++){
        //     if(!inRec[i]){
        //         ans.add(i) ;
        //     }
        // }

        // return ans ;
    }
}