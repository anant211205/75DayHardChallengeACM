class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Stack<Integer> st = new Stack<>() ;
        int n = happiness.length ;
        Arrays.sort(happiness) ;
        long sum = 0 ;

        int dec = 0 ;

        for(int i=n-1;i>=0;i--){

            st.push(happiness[i] - dec) ;
            dec++ ;

            if(st.size() == k) break ;

        }

        while(!st.isEmpty()){
            int pop = st.pop() ;
            if(pop >= 0){
                sum += (long)(pop) ;
            }
        }

        return sum ;

    }
}