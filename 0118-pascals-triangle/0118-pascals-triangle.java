class Solution {
    public List<Integer> NthRow(int row){
        long res = 1 ;
        List<Integer> ansRow = new ArrayList<>(); 
        ansRow.add(1) ;
        for(int i = 0 ; i < row ;i++){
            res = res * (row - i) ;
            res = res / (i + 1) ;
            ansRow.add((int)res) ;
        }
        return ansRow ;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>() ;
        for(int i = 0 ; i < numRows ; i++){
            ans.add(NthRow(i));
        }
        return ans ;
    }
}