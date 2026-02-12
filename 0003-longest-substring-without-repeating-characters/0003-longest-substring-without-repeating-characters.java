class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=s.length();
        int i=0;
        int j=0;
        int m=0;
        HashSet<Character> set=new HashSet<>();
        while( j<l){

            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                 j++;
                  m=Math.max(m,j-i);
            // System.out.println("j="+j);
            }
            else{
                set.remove(s.charAt(i));
                i++;
                // System.out.println("i"+i);
            }
           
            // System.out.println("m="+m);
            
        
        }
        return m;
    }
}