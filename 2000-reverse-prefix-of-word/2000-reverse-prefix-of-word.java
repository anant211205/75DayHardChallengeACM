class Solution {
    public char[] reverseArray(char[] arr , int i , int j){
        while(i<j){
            char temp = arr[i] ;
            arr[i] = arr[j] ;
            arr[j] = temp ;
            i++ ;
            j-- ;
        }

        return arr ;
    }
    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray() ;

        int idx = 0 ;
        for(int i=0;i<chars.length;i++){
            if(chars[i] == ch){
                idx = i ;
                break ;
            }
        }
        reverseArray(chars , 0 , idx) ;

        return new String(chars) ;
    }
}