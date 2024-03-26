class Solution {
    public String add(String num1 , String num2){
        int idx1 = num1.length()-1 , idx2 = num2.length()-1 ;
        int carry = 0 , sum = 0 ;
        String ans = "";

        while(idx2>=0){
            sum = (num1.charAt(idx1)-'0') + (num2.charAt(idx2)-'0') + carry ;
            carry = sum / 10 ;
            char c = (char)('0'+ sum%10) ;
            ans += c ;
            idx1--;
            idx2--;
        }

        while(idx1>=0){
            sum = (num1.charAt(idx1)-'0') + carry ;
            carry = sum / 10 ;
            char c = (char)('0'+ sum%10) ;
            ans += c ;
            idx1--;
        }
        if(carry==1) ans+='1' ;
        return new StringBuilder(ans).reverse().toString();
    }
    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()) return add(num2,num1) ;
        else return add(num1 , num2) ;
    }
}