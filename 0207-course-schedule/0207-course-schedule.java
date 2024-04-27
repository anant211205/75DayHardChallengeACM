class Solution {

    public boolean isCycleDFS(ArrayList<Integer>[] adj , int node , boolean[]vis , boolean[]inRec){
        vis[node] = true ;
        inRec[node] = true ;

        for(int i : adj[node]){
            if(!vis[i] && isCycleDFS(adj , i , vis , inRec)){
                return true ;
            }else if(inRec[i]){
                return true ;
            }
        }
        inRec[node] = false ;

        return false ;
    }

    public boolean topoSort(ArrayList<Integer>[] adj , int n ,int[]indegree){
        Queue<Integer> que = new LinkedList<>() ;

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                que.add(i) ;
            }
        }

        int count = 0 ;
        while(!que.isEmpty()){
            int u = que.poll() ;
            count++ ;

            for(int v : adj[u]){
                indegree[v]-- ;
                if(indegree[v] == 0){
                    que.add(v) ;
                }
            }
        }
        if(count==n) return true; // all courses are done
        return false ; // there was a cycle 
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<>(); 
        }
        //dfs
        boolean[] vis = new boolean[numCourses] ;
        boolean[] inRec = new boolean[numCourses] ;
        for(int[] arr : prerequisites){
            int a = arr[0] ;
            int b = arr[1] ;

            //b--->a
            adj[b].add(a) ;
        }

        for(int i=0;i<numCourses;i++){
            if(!vis[i] && isCycleDFS(adj , i , vis , inRec)){
                return false ; // it means cycle present and cannot complete all courses
            }
        }
        return true ;// it means can complete all courses
        

        //bfs
        // int n = prerequisites.length ;
        // int[]indegree = new int[numCourses] ;
        // for(int i=0;i<numCourses;i++){
        //     adj[i] = new ArrayList<>(); 
        // }

        // for(int[] arr : prerequisites){
        //     int a = arr[0] ;
        //     int b = arr[1] ;

        //     //b--->a
        //     adj[b].add(a) ;

        //     indegree[a]++ ;
        // }

        // return topoSort(adj , numCourses , indegree) ;

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(prerequisites[i][j] == 1){
        //             adj[i].add(j) ;
        //             adj[j].add(i) ;
        //         }
        //     }
        // }
    }
}