class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer , Integer> map = new HashMap<>() ;
        int [] ans = new int[arr1.length] ;
        for(int i : arr1){
            map.put(i , map.getOrDefault(i , 0) + 1) ;
        }
        int j = 0 ;
        for(int i : arr2){
            while(map.get(i) != 0){
                ans[j++] = i ;
                map.put(i , map.get(i) - 1) ;
            }
            map.remove(i) ;
        }

        ArrayList<Integer> rem = new ArrayList<>() ;

        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            int count = entry.getValue() ;
            while(count-- > 0){
                rem.add(entry.getKey()) ;
            }
        }

        Collections.sort(rem) ;
        for(int i : rem){
            ans[j++] = i ;
        }

        return ans ;
    }
}