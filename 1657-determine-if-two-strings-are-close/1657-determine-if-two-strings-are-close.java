class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length() , m = word2.length() ;

        int[] l1 = new int[26] ;
        int[] l2 = new int[26] ;

        HashSet<Character> set1 = new HashSet<>() ;
        HashSet<Character> set2 = new HashSet<>() ;

        if(n != m) return false ;

        for(int i = 0 ; i < n ; i++){

            set1.add(word1.charAt(i)) ;
            set2.add(word2.charAt(i)) ;
            l1[word1.charAt(i) - 'a']++ ;
            l2[word2.charAt(i) - 'a']++ ;

        }

        Arrays.sort(l1) ;
        Arrays.sort(l2) ;

        // for(int i = 0 ; i < 26 ; i++){

        //     if(l1[i] != l2[i]) return false ;

        // }

        if(set1.equals(set2) && Arrays.equals(l1,l2)) return true ; 

        return false ;
    }
}