class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0 , j = 0 ;
        int n1 = s.length() , n2 = t.length() ;
        StringBuilder sb = new StringBuilder(); 
        while(i<n1 && j<n2){
            if(s.charAt(i)==t.charAt(j)) {
                sb.append(t.charAt(j)) ;
                i++;
                j++;
            }else{
                j++ ;
            }
        }
       if(sb.toString().equals(s)) return true ;

       return false ;

    }
}