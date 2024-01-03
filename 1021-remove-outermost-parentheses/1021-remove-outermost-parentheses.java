class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>() ;
        StringBuilder sb = new StringBuilder(""); 
        int n =  s.length() ;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '('){
                if(st.size() > 0) sb.append(s.charAt(i)) ;
                st.push(s.charAt(i)) ;
            }else{
                st.pop() ;
                if(st.size() > 0) sb.append(s.charAt(i)) ;
            }
        }
        return sb.toString(); 
    }
}