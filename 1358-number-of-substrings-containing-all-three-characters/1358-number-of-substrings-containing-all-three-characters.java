class Solution {
    public int numberOfSubstrings(String s) {
      
       int l=s.length();
       int [] ar={-1,-1,-1};
       int c=0;
      for(int i=0;i<l;i++){
        char ch=s.charAt(i);
        ar[ch-'a']=i;
        c=c+1+Math.min(ar[0],Math.min(ar[2],ar[1]));

      } 
      return c;
 
    }
}