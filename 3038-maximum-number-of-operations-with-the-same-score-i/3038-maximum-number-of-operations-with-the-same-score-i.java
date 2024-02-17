class Solution {
    public int maxOperations(int[] nums) {
        int score = 0 ;
        Stack<Integer> st = new Stack<>() ;
        ArrayList<Integer> ls = new ArrayList<>() ;
        int n = nums.length ;
        
        for(int i=0;i<n;i++){
            ls.add(nums[i]) ;
        }
        
        for(int i=0;i<ls.size()-1;i+=2){
            score = ls.get(i) + ls.get(i+1) ;
            if(st.isEmpty() || st.peek() == score){
                st.push(score) ;
            }else if(st.peek() != score) break ;
        }
        
        return st.size() ;
    }
}