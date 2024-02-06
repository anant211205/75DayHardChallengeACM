class Solution {
    public void reverseString(char[] s) {
        int n = s.length ;
        Stack<Character> st = new Stack<>() ;
        int stSize = st.size() ;
        for(int i = 0 ; i < n ; i++){
            st.push(s[i]) ;
        }
        int index = 0 ;
        while(!st.isEmpty()){
            char ch = st.pop() ;
            s[index++] = ch ;
        }
    }
}