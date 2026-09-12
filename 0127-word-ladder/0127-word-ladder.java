class Solution {
    class Pair{
        String first;
        int second;
        public Pair(String f,int s){
            this.first=f;
            this.second=s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        HashSet<String> s=new HashSet<>();
        int l=wordList.size();
        for(int i=0;i<l;i++){
            s.add(wordList.get(i));
        }
        q.add(new Pair(beginWord,1));
        s.remove(beginWord);
        while(!q.isEmpty()){
            String w=q.peek().first;
            int c=q.peek().second;
            q.remove();
            if(w.equals(endWord)){
                return c;
            }
            for(int i=0;i<w.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] rep=w.toCharArray();
                    rep[i]=ch;
                    String finall=new String(rep);
                    if(s.contains(finall)){
                        s.remove(finall);
                        q.add(new Pair(finall,c+1));
                    }
                }
            }
        }
        return 0;

    }
}