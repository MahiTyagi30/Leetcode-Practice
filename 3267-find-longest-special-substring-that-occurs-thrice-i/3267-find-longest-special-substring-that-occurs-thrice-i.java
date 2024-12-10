class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer> h=new HashMap<>();
        int l=s.length();
        for(int i=0;i<l;i++){
            for(int j=i;j<l;j++){
                    StringBuilder sb=new StringBuilder();
                    for(int k=i;k<=j;k++){
                        sb.append(s.charAt(k));
                    }
                    Set<Character> uq=new HashSet<>();
                    for(int p=0;p<sb.length();p++){
                        uq.add(sb.charAt(p));
                    }
                    if(uq.size()==1){
                        h.put(sb.toString(),h.getOrDefault(sb.toString(),0)+1);
                    }
            }
        }

        int mx=-1;
        for(Map.Entry<String,Integer> e:h.entrySet()){
            if(e.getValue()>=3){
                mx=Math.max(mx,e.getKey().length());
            }
        }
        return mx;
    }
}