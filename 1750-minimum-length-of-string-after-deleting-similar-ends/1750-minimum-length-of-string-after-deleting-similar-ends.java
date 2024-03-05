class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int st = 0 , end = n-1;
        while(st<end && s.charAt(st)==s.charAt(end)){
            char c = s.charAt(st);
            while(st<=end && s.charAt(st) == c){
                st++;
            }
            while(st<end && s.charAt(end) == c){
                end--;
            }
        }
        return end - st + 1 ;
    }
}