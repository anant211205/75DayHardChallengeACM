class Solution {
    public int compareVersion(String s, String t) {
        int n = s.length() ;
        int m = t.length() ;
        int i = 0 , j = 0 ;

        while(i<n || j<m){
            int num1 = 0 , num2 = 0 ;
            while(i<n && s.charAt(i) != '.'){
                num1 = num1*10 + (s.charAt(i++) - '0') ;
            }
            while(j<m && t.charAt(j) != '.'){
                num2 = num2*10 + (t.charAt(j++) - '0') ;
            }
            if(num1>num2)return 1;
            if(num1<num2)return -1;
            i++ ;
            j++ ;
        }
        return 0 ;
    }
}