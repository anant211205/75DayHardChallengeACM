class Solution {

    public String findRoot(String s , HashSet<String> set){
        for(int i=1;i<=s.length();i++){
            String sub = s.substring(0 , i); 
            if(set.contains(sub)){
                return sub ;
            }
        }
        return s ;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> st = new HashSet<>(dictionary) ;
        String []words = sentence.split(" ") ;

        StringBuilder sb = new StringBuilder() ;

        for(String s : words){
            sb.append(findRoot(s , st)).append(" ") ;
        }

        return sb.toString().trim() ;
    }
}