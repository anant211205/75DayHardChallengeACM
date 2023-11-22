class Solution {
public:
    int trap(vector<int>& height) {
        
        int n = height.size() , rightMax[n] , leftMax[n], maxi=1e-9;
        
        for(int i=0; i<n; ++i){
            maxi = max(maxi , height[i]);
            leftMax[i] = maxi;
        }
        maxi = 1e-9;
        for(int i=n-1; i>=0; --i){
            maxi = max(maxi , height[i]);
            rightMax[i] = maxi;
        }
        
        int res = 0;
        
        for(int i=0; i<n; ++i){
            res += min(leftMax[i] , rightMax[i]) - height[i];
        }
        return res;
    }
};