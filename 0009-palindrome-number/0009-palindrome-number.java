class Solution {
    public boolean isPalindrome(int x) {
        int num = 0 , rem = 0 ;
        int originalX = x;
        while(x > 0){
            rem = x%10 ;
            num = num*10 + rem ;
            x/=10 ;
        }
        return num == originalX ;
    }
}