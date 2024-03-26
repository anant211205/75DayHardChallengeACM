class Solution {
    public String sortVowels(String s) {
        StringBuilder ans = new StringBuilder("");
        ArrayList<Character> ls = new ArrayList<>() ;

        int n = s.length() ;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i) ;
            if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||
                ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') 
                ls.add(ch) ;
        }
        Collections.sort(ls);
        int idx = 0 ;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i) ;
            if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||
                ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    ans.append(ls.get(idx++)) ;
                }else{
                    ans.append(ch); 
                }
        }
        return ans.toString() ;
    }
}