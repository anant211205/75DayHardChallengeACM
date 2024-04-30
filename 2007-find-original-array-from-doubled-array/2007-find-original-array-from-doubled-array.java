import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length; 
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        
        Arrays.sort(changed);
        
        if ((n & 1) != 0) {
            return new int[0]; 
        }

        for (int i = 0; i < n; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }

        for (int num : changed) {
            int twice = 2 * num;

            if (map.get(num) == 0) {
                continue;
            }

            if (!map.containsKey(twice) || map.get(twice) == 0) {
                return new int[0];
            }

            ls.add(num);
            map.put(num, map.get(num) - 1);
            map.put(twice, map.get(twice) - 1);
        }

        int[] ans = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            ans[i] = ls.get(i);
        }
        return ans;
    }
}
