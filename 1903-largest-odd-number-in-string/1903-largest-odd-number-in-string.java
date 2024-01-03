class Solution {
    public String largestOddNumber(String num) {
        int index = num.length() - 1;
        while(index > -1 && (num.charAt(index) - '0') % 2 == 0){
            index-- ;
        }
        return num.substring(0 , index + 1) ;
    }
}