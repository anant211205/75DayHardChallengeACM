class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length ;
        int m = mat[0].length ;
        HashMap<Integer , List<Integer>> map = new HashMap<>() ;
        int []arr = new int[m*n] ;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!map.containsKey(i+j)){
                    map.put(i+j , new ArrayList<>()) ;
                }
                map.get(i+j).add(mat[i][j]) ;
            }
        }

        int k = 0 ;
        for(int i=0;i<=m+n-2 ;i++){
            if((i&1)==0){
                Collections.reverse(map.get(i)) ;
            }
            for(int j : map.get(i)){
                arr[k++] = j ;
            }
        }
        return arr ;
    }
}