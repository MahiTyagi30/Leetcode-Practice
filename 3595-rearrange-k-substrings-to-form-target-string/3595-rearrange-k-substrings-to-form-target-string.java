class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        ArrayList<String> l1=new ArrayList<>();
          ArrayList<String> l2=new ArrayList<>();
          int a=s.length()/k;
          for(int i=0;i<s.length();i=i+a){
            l1.add(s.substring(i,i+a));
            l2.add(t.substring(i,i+a));
          }
          Collections.sort(l1);
           Collections.sort(l2);
           if(l1.equals(l2)){
            return true;
           }
           return false;
    }
}