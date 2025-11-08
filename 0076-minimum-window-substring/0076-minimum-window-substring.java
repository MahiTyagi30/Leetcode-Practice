import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
      
    HashMap<Character,Integer> m1=new HashMap<>();
    HashMap<Character,Integer> m2=new HashMap<>();
    int l1=s.length();
    int l2=t.length();
    for(int i=0;i<l2;i++){
        char ch=t.charAt(i);
        // m1.put(map.getOrDefault(ch,0)+1);
         m1.put(ch,m1.getOrDefault(ch,0)+1);
    }
    int need=m1.size();
    int l=0;
    int minLen = Integer.MAX_VALUE;
    int count=0;
    int si=-1;

    for(int r=0;r<l1;r++){
        char ch=s.charAt(r);
        m2.put(ch,m2.getOrDefault(ch,0)+1);
        if(m1.containsKey(ch)&&m1.get(ch).intValue()==m2.get(ch).intValue()){
            count++;
            // m2.put(ch,m2.getOrDefault(ch,0)-1);
        }
        while(count==need){
            if(r-l+1<minLen){
                minLen=r-l+1;
                si=l;
            }
        char c=s.charAt(l);
        m2.put(c,m2.getOrDefault(c,0)-1);
        if(m1.containsKey(c)&& m2.get(c)<m1.get(c)){
          count--;
        
        }
        l++;
        }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(si, si + minLen);
        
    }
}