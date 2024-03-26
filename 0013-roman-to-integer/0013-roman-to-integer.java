class Solution {
    public int number(char c){
        if(c=='I')return 1 ;
        else if(c=='V')return 5 ;
        else if(c=='X')return 10;
        else if(c=='L')return 50 ;
        else if(c=='C')return 100 ;
        else if(c=='D')return 500 ;
        else return 1000 ;
    }
    public int romanToInt(String s) {
        int n = s.length() ;
        int idx = 0; int sum = 0 ;
        while(idx<n-1){
            if(number(s.charAt(idx)) < number(s.charAt(idx+1))) sum -= number(s.charAt(idx)) ;
            else sum+=number(s.charAt(idx)) ;
            idx++ ;
        }
        sum+=number(s.charAt(n-1)) ;
        return sum ;
    }
}