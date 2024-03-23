class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128] ;
        for(char c : s.toCharArray()){
            freq[c]++ ;
        }

        int count = 0; 
        boolean odd = false ;
        for(int i : freq){
            if(i % 2==0) count+=i ;
            if(i % 2==1) {
                count+= i-1 ;
                odd = true; 
            }
        }

        if(odd) count++ ;

        return count; 

        // int [] lower = new int[27] ;    
        // int [] upper = new int[27] ; 
        // int n = s.length() ;

        // for(int i=0;i<n;i++){
        //     if(s.charAt(i) >= 'a') lower[s.charAt(i) - 'a']++ ;
        //     else upper[s.charAt(i) - 'A']++ ;
        // }   
        // int count = 0 ;
        // boolean odd = false ;
        // for(int i=0;i<26;i++){
        //     if(lower[i]%2==0){
        //         count += lower[i] ;
        //     }else{
        //         count+= lower[i] - 1 ;
        //         odd = true ;
        //     }
        //     if(upper[i]%2==0){
        //         count += upper[i] ;
        //     }else{
        //         count+= upper[i] - 1 ;
        //         odd = true ;
        //     }
        // }
        // if(odd == true) return count + 1 ;

        // else return count ;
    }
}