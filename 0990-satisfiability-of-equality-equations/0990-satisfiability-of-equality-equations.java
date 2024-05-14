class Solution {
    public int find(int x , int[] parent){
        if(x == parent[x]) return x ;

        return parent[x] = find(parent[x] , parent) ;
    }

    public void union(int x , int y , int[] parent , int[] rank){
        int x_parent = parent[x] ;
        int y_parent = parent[y] ;

        if(x_parent == y_parent) return ;

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent ;
        }else if(rank[y_parent] > rank[x_parent]){
            parent[x_parent] = y_parent ;
        }else{
            parent[x_parent] = y_parent ;
            rank[y_parent] += 1 ;
        }
    }

    public boolean equationsPossible(String[] equations) {
        int []parent = new int[26] ;
        int []rank = new int[26] ;
        for(int i=0;i<26;i++){
            parent[i] = i ;
        }
        int n = equations.length ;

        for(String s : equations){
            if(s.charAt(1) == '='){
                union(s.charAt(0)-'a' , s.charAt(3)-'a' , parent , rank) ;
            }
        }

        for(String s : equations){
            if(s.charAt(1) == '!'){
                char first = s.charAt(0) ;
                char second = s.charAt(3) ;

                int findF = find(first - 'a' , parent) ;
                int findS = find(second - 'a', parent) ;

                if(findF==findS) return false;
            }
        }
        return true ;
    }
}