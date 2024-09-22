class Solution {
public:
    int cntToSkip(long cur,long nxt,int n){
        int cnt=0;
        while(cur<=n){
            cnt+=(nxt-cur);
            cur*=10;
            nxt*=10;
            //as curr=n(max value) , next=curr+1 => nxt=n+1
            nxt=min(nxt,long(n+1));
        }
        return cnt;
    }

    int findKthNumber(int n, int k) {
        int cur=1;k-=1;
        while(k>0){
            int curCnt=cntToSkip(cur,cur+1,n);
            if(curCnt<=k){
                cur+=1;
                k-=curCnt;
            }else{
                cur*=10;
                k-=1;
            }
        }
        return cur;
    }
};