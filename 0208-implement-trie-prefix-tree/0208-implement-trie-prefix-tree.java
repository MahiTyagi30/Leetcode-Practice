class Trie {
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }


    }
    private TrieNode root;

    public Trie() {
    root=new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr=curr.children[idx];

        }
        curr.isEnd=true;

    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char ch:prefix.toCharArray()){
            int idx=ch-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */