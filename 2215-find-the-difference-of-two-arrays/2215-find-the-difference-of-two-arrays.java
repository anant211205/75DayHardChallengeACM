class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int n1 = nums1.length , n2 = nums2.length ;
        List<List<Integer>> ls = new ArrayList<>() ;
        List<Integer> ans1 = new ArrayList<>() ;
        List<Integer> ans2 = new ArrayList<>() ;
        HashSet<Integer> st1 = new HashSet<>() ;
        HashSet<Integer> st2 = new HashSet<>() ;

        for(int i : nums1)st1.add(i);
        for(int i : nums2)st2.add(i);
        for(int i : st1){
            if(st2.contains(i)==false) ans1.add(i) ;
        }
        for(int i : st2){
            if(st1.contains(i)==false) ans2.add(i) ;
        }
        ls.add(ans1) ;
        ls.add(ans2) ;

        return ls ;  
    }
}