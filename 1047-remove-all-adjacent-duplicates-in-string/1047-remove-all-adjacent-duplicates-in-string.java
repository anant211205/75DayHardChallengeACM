class Solution {
    public String removeDuplicates(String s) {
        int n = s.length() ;
        Stack<Character> st = new Stack<>() ;

        st.add(s.charAt(0)) ;
        for(int i = 1 ; i < n ; i++){

            if(!st.isEmpty() && st.peek().equals(s.charAt(i))){
                st.pop() ;
                continue ;
            }else{
                st.add(s.charAt(i)) ;
            }
        }
        String ans = "" ;
        while(!st.isEmpty()){
            ans = st.pop() + ans ;
        }

        return ans ;
    }
}