class Solution {
public:
    string shortestPalindrome(string s) {
        int n=s.size();
        string rev=s;
        reverse(rev.begin(),rev.end());
        for(int i=0;i<n;i++){
            // this is inbuild funtion for cpp 
            // takes 3 argument 
            // 1st -> string 1 + some index;
            // 2nd -> string 2 + some index ;
            // 3rd -> common length in both string;
            if(!memcmp(s.c_str()+0 , rev.c_str()+i , n-i)){
                return rev.substr(0,i)+s;
            }
        }
        return rev+s;
    }
};