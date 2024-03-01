class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public void swap(char []word , int start , int end){
        char temp = word[start]; 
        word[start] = word[end] ;
        word[end] = temp ;
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray() ;
        int start = 0 , end = s.length() - 1 ;

        while(start < end){
            while(start<end && !isVowel(chars[start])) start++ ;
            while(start<end && !isVowel(chars[end])) end-- ;

            if(start<end){
                swap(chars,start,end) ;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}