class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>() ;

        int n = s.length() ;

        for(int i = 0 ; i < n ; i++){

            if(!st.isEmpty() && st.peek() == 'A'){

                if(s.charAt(i) == 'B'){
                    st.pop() ;
                } 

                else st.push(s.charAt(i)) ;

                continue ;

            }
            else if(!st.isEmpty() && st.peek() == 'C'){
                
                if(s.charAt(i) == 'D') {
                    
                    st.pop() ;
            
                }

                else st.push(s.charAt(i)) ;

                continue ;

            }

            st.push(s.charAt(i)) ;

        }

        return st.size() ;
    }
}