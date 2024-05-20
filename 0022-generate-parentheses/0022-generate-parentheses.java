class Solution {
    // public boolean isValid(String s){
    //     int count = 0 ;
    //     for(int i=0;i<s.length();i++){
    //         if(s.charAt(i) == '('){
    //             count++ ;
    //         }else{
    //             count-- ;
    //         }
    //         if(count < 0) return false ;
    //     }
    //     return count == 0 ;
    // }

    // public void solve(String s , int n , int length , List<String> result){
    //     if(s.length() == n*2){
    //         if(isValid(s)){
    //             result.add(s);
    //         }
    //         return ;
    //     }

    //     s += '(' ;
    //     solve(s , n , length + 1 , result) ;
    //     s = s.substring(0 , s.length() - 1) ;

    //     s += ')' ;
    //     solve(s  , n , length + 1 , result) ;

    // }

    //approach 2

    public void solve(String s , int n ,int length , int open , int close , List<String> result){
        if(s.length() == n*2){
            result.add(s);
            return ;
        }

        if(open < n){
            s += '(' ;
            solve(s , n , length + 1 ,open + 1 , close , result) ;
            s = s.substring(0 , s.length() - 1) ;
        }
        if(close < open){
            s += ')' ;
            solve(s  , n , length + 1 , open , close + 1 , result) ;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>() ;
        int open = 0 ;
        int close = 0 ;
        solve("" , n , 0 , open  , close  ,res) ;
        return res ;
    }
}