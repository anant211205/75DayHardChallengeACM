class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>() ;

        for(int i : nums1){
            set.add(i); 
        }

        HashSet<Integer> intersectionSet = new HashSet<>() ;

        for(int num : nums2){
            if(set.contains(num)){
                intersectionSet.add(num) ;
                set.remove(num) ;
            }
        }

        int[] arr = new int[intersectionSet.size()] ;
        int index = 0 ;
        for(int num : intersectionSet){
            arr[index++] = num ;
        }

        return arr ;
    }
}