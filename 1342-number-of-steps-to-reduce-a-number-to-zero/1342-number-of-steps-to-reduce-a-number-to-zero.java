class Solution {
    public int countSteps(int N , int count){
        if(N == 0) return count ;

        if(N % 2 == 0) return countSteps(N / 2 , count + 1); 

        return countSteps(N - 1 ,count + 1) ;
    }
    public int numberOfSteps(int num) {
        return countSteps(num , 0); 
    }
}