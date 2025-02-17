class Solution {
    public int fun(int[] charCount){
        int tc=0;
        for(int i=0;i<26;i++){
            if(charCount[i]>0){
                tc++;
                charCount[i]--;
                tc=tc+fun(charCount);
                charCount[i]++;
            }
        }
        return tc;
    }
    public int numTilePossibilities(String tiles) {
        int [] charCount=new int [26];
        for(char ch :tiles.toCharArray()){
            charCount[ch-'A']++;
        }
        return fun(charCount);
        
    }
}