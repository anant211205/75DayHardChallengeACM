class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length ;
        HashMap<String , List<String>> map = new HashMap<>() ;

        for(String word : strs){
            char[] chars = word.toCharArray() ;
            Arrays.sort(chars) ;

            String sortedWord = new String(chars) ;

            if(!map.containsKey(sortedWord)){
                map.put(sortedWord , new ArrayList<>()) ;
            }
            map.get(sortedWord).add(word) ;
        }

        return new ArrayList<>(map.values()) ;

        // List<List<String>> ans = new ArrayList<>() ;
        // for(int i=0;i<n;i++){
        //     String s = sortString(strs[i]) ;
        //     if(hm.containsKey(s)){
        //         hm.get(s).add(strs[i]) ;
        //     }else{
        //         List<String> list = new ArrayList<>();
        //         list.add(strs[i]);
        //         hm.put(s , list) ;
        //     }
        // }

        // // List<String> ls = new ArrayList<>() ;
        // for(String key : hm.keySet()){
        //     ans.add(hm.get(key)) ;
        // }

        // return ans ;
    }
}