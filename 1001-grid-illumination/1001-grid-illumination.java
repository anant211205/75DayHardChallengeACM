import java.util.*;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer,Integer> m1,m2,m3,m4,m5;
         m1 = new HashMap<>();
         m2 = new HashMap<>();
         m3 = new HashMap<>();
         m4 = new HashMap<>();
         m5 = new HashMap<>();
        for(int i =0; i<lamps.length; i++){
            int x = lamps[i][0];
            int y = lamps[i][1];
            m1.put(x , m1.getOrDefault(x,0) + 1);
            m2.put(y , m2.getOrDefault(y,0) + 1);
            m3.put(x-y , m3.getOrDefault(x-y,0) + 1);
            m4.put(x+y , m4.getOrDefault(x+y,0) + 1);
            m5.put(x*n+y , m5.getOrDefault(x*n+y,0) + 1);
        }
        int[] ans = new int[queries.length];
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{0,0}};   
        
        for(int i = 0; i<queries.length; i++){
            int x = queries[i][0];
            int y = queries[i][1];
            if(m1.getOrDefault(x,0)>0 || m2.getOrDefault(y,0)>0 || m3.getOrDefault(x-y,0)>0 || m4.getOrDefault(x+y,0)>0){
                ans[i] = 1;
            } 
            for(int d= 0; d<dirs.length; d++){
                int x1 = x+dirs[d][0];
                int y1 = y+dirs[d][1];
                if(x1>=0 && y1>=0 && x1<n && y1<n && m5.containsKey(x1*n+y1)==true){
                    int times = m5.get(x1*n+y1);
                     m1.put(x1 , m1.getOrDefault(x1,0)-times);
                     m2.put(y1 , m2.getOrDefault(y1,0)-times);
                     m3.put(x1-y1 , m3.getOrDefault(x1-y1,0)-times);
                     m4.put(x1+y1 , m4.getOrDefault(x1+y1,0)-times);
                     m5.remove(x1*n+y1);
                }
            }
            
        }
        return ans;

    }
}
