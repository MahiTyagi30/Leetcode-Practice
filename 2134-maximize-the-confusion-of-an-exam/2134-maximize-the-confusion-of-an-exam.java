class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int l=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        int i=0;
        int maxfre=0;
        int res=0;
        for(int j=0;j<l;j++){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxfre=Math.max(maxfre,map.get(ch));
            while((j-i+1)-maxfre>k){
                char ch2=s.charAt(i);
                map.put(ch2,map.get(ch2)-1);
                i++;
            }
            res=Math.max(res,j-i+1);
        }
        return res;
        
        
    }
}