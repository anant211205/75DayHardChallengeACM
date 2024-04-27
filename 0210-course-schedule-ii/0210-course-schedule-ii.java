class Solution {
    public boolean isCycle = false ;
    public void topoSortDFS(int node ,ArrayList<Integer>[] adj , Stack<Integer> st , boolean[]vis , boolean[] inRec){
        vis[node] = true; 
        inRec[node] = true ;
        for(int i : adj[node]){
            if(inRec[i] == true){
                isCycle = true; 
                return ;
            }
            if(!vis[i]){
                topoSortDFS(i , adj , st , vis , inRec) ;
            }
        }
        inRec[node] = false ;
        st.push(node) ;
    }

    public int[] topoOrderBFS(int n , ArrayList<Integer>[] adj , int[]indegree){
        Queue<Integer> que = new LinkedList<>() ; 
        int[] order = new int[n] ;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                que.add(i) ;
            }
        }

        int j = 0 ;
        while(!que.isEmpty()){
            int u = que.poll() ;
            order[j++] = u ;

            for(int v : adj[u]){
                indegree[v]-- ;
                if(indegree[v]==0){
                    que.add(v) ;
                }
            }
        }

        //checking if all the courses are completed return the order else empty array
        if(j==n) return order ;

        // means there is no order
        else return new int[0] ;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses] ;
        for(int i=0;i<numCourses ;i++){
            adj[i] = new ArrayList<>() ;
        }

        // bfs
        int []indegree = new int[numCourses] ;
        int[] ans = new int[numCourses] ;
        // for(int[] arr : prerequisites){
        //     int a = arr[0] ;
        //     int b = arr[1] ;

        //     //b--->a 
        //     adj[b].add(a) ;
        //     indegree[a]++ ;
        // }

        // return topoOrder(numCourses , adj , indegree) ;

        //dfs
        
        for(int[] arr : prerequisites){
            int a = arr[0] ;
            int b = arr[1] ;

            //b--->a 
            adj[b].add(a) ;
        }
        Stack<Integer> st = new Stack<>() ;
        boolean []vis = new boolean[numCourses] ;
        boolean []inRec = new boolean[numCourses] ;
        int j = 0 ;
        isCycle = false ;
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                topoSortDFS(i , adj , st , vis , inRec) ;
            }
        }
        while(!st.isEmpty()){
            ans[j++] = st.pop() ;
        }
        if(isCycle){
            return new int[0] ;
        }
        else return ans ;
    }
}