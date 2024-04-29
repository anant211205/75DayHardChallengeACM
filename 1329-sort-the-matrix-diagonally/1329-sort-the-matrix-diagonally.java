class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length ;
        int m = mat[0].length ;
        HashMap<Integer , List<Integer>> map = new HashMap<>() ;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!map.containsKey(j-i)){
                    map.put(j-i , new ArrayList<>()) ;
                }
                map.get(j-i).add(mat[i][j]) ;
            }
        }

        for(Map.Entry<Integer , List<Integer>> entry : map.entrySet()){
            Collections.sort(entry.getValue()) ;
        }

        for(int i=n-1 ;i>=0 ;i--){
            for(int j=m-1 ;j>=0;j--){
                int size = map.get(j-i).size() ;
                mat[i][j] = map.get(j-i).get(size-1) ;
                map.get(j-i).remove(size-1) ;
            }
        }
        return mat ;
    }
}