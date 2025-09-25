class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if (s1.length() > s2.length()) {
            return false;
        }
        int c1[]=new int[26];
        int c2[]=new int[26];
        int l1=s1.length();
        int l2= s2.length();
        for(int i=0;i<l1;i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            c1[ch1-'a']++;
            c2[ch2-'a']++;
        }
        int matches=0;
        for(int i=0;i<26;i++){
            if(c1[i]==c2[i]){
                matches++;
            }
        }
        int l=0;
        for(int r=l1;r<l2;r++){
            if(matches==26){
                return true;
            }
            int idx=s2.charAt(r) - 'a';
            c2[idx]++;
            if(c1[idx]==c2[idx]){
                matches++;
            }
            else if(1+c1[idx]==c2[idx]){
                matches--;
            }
             idx = s2.charAt(l) - 'a';
             c2[idx]--;
             if(c1[idx]==c2[idx]){
                matches++;
            }
            else if(c1[idx]-1==c2[idx]){
                matches--;
            }
            l++;
        }
        return matches==26;

    }
}