class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        
       int l1=s1.length();
        int l2=s2.length();
        if(l1>l2){
            return new ArrayList<>();
        }
        int c1[]=new int [26];
        int c2[]=new int[26];
        int matches=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<l1;i++){
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(c1[i]==c2[i]){
                matches++;
            }
        }
        int l=0;
        for(int r=l1;r<l2;r++){
            if(matches==26){
                list.add(l);
            }
            int idx=s2.charAt(r)-'a';
            c2[idx]++;
            if(c1[idx]==c2[idx]){
                matches++;
            }
            else if(c1[idx]+1==c2[idx]){
                matches--;
            }
             idx=s2.charAt(l)-'a';
             c2[idx]--;
             if(c1[idx]==c2[idx]){
                matches++;
            }
            else if(c1[idx]==c2[idx]+1){
                matches--;
            }
            l++;
             


        }
         if (matches == 26) list.add(l);
        return list;
        
    }
}