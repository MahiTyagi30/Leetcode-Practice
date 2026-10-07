class Solution {
    class TrieNode{
        TrieNode children[]=new TrieNode[2];
    }
    TrieNode root=new TrieNode();
    public void insert(int num){
        TrieNode curr=root;
        for(int i=30;i>=0;i--){
            int bit=(num>>i)&1;
            if(curr.children[bit]==null){
                curr.children[bit]=new TrieNode();
            }
            curr=curr.children[bit];
        }
    }
    public int getmaxOr(int num){
        TrieNode curr=root;
        int xor=0;
        for(int i=30;i>=0;i--){
            int bit=(num>>i)&1;
            int opp=1-bit;
            if(curr.children[opp]!=null){
                xor=xor|(1<<i);
                curr=curr.children[opp];


            }
            else{
                 curr = curr.children[bit];
            }
        }
        return xor;
    }
    public int findMaximumXOR(int[] nums) {
        for(int num:nums){
            insert(num);
        }
        int ans=0;
        for(int num:nums){
            ans=Math.max(ans,getmaxOr(num));
        }
        return ans;
        
    }
}