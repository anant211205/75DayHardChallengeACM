class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length ;

        Stack<Integer> st = new Stack<>();

        for(int i : asteroids){
            while(!st.isEmpty() && st.peek() > 0 && i < 0){

                if(Math.abs(i) == st.peek()){
                    st.pop();
                    i=0;
                    break ;
                }
                else if(Math.abs(i) > st.peek()){
                    st.pop() ;
                }else{
                    i=0;
                    break;
                }
            }
            if(i!=0) st.push(i) ;
        }
        int [] result = new int[st.size()] ;
        for(int i = result.length-1;i>=0;i--){
            result[i]=st.pop();
        }

        return result; 
    }
}