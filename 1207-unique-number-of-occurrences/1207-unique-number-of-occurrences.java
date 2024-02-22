class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length ;
        HashMap<Integer,Integer> mp=new HashMap<>();
        HashSet<Integer> st = new HashSet<>(); 
        for(int i=0;i<n;i++){
            if(mp.containsKey(arr[i])){
                int temp = mp.get(arr[i]) ;
                mp.put(arr[i] ,temp+1);
            }else{
                mp.put(arr[i],1); 
            }
        }

        for(int i : mp.keySet()){
            if(!st.add(mp.get(i))){
                return false ;
            } 
        }

        return true ;
        

        

    }
}