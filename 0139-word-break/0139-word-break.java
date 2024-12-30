class Solution {
    private HashMap<String,Boolean> dp;
    public boolean solve(String s,HashSet<String> hs){
        if(s.length()==0){
            return true;
        }

        if(dp.containsKey(s)){
            return dp.get(s);
        }

        for(int i=0;i<s.length();i++){
            String sub=s.substring(0,i+1);
            if(hs.contains(sub)){
              if (solve(s.substring(i + 1), hs)){
                    dp.put(s,true);
                    return true;
                }   
            }
        }
        dp.put(s, false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs=new HashSet<>(wordDict);
        dp=new HashMap<>();
        return solve(s,hs);
    }
}