class Solution {
    int lpsFind(String s , int[] lps) {
        int pre = 0 , suff = 1 ;
        int n = s.length() ;
        while(suff<n){
            if(s.charAt(pre)==s.charAt(suff)){
                lps[suff] = pre+1 ;
                pre++;
                suff++; 
            }else{
                if(pre==0){
                    lps[suff] = 0 ;
                    suff++ ;
                }else{
                    pre = lps[pre-1] ;
                }
            }
        }
        return lps[lps.length-1] ;
    }
    public int strStr(String haystack, String needle) {
        int[] lps = new int[needle.length()] ;
        lpsFind(needle , lps) ;

        int second = 0 , first = 0 ;
        while(second<needle.length() && first<haystack.length()){
            if(needle.charAt(second)==haystack.charAt(first)){
                first++;
                second++ ;
            }else{
                if(second==0){
                    first++;
                }else{
                    second = lps[second-1] ;
                }
            }
        }
        if(second==needle.length()) return first - second ;
        else return -1 ;
    }
}