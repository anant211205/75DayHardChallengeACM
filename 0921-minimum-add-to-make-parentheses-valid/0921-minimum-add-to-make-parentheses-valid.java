class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length() ;
        int count = 0 ;
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){

            char ch = s.charAt(i) ;

            if(ch == '(') st.push(ch) ;
            
            else{

                if(st.isEmpty()) count++ ;

                else st.pop() ;
            }

        }
        return count + st.size() ;
    }
}