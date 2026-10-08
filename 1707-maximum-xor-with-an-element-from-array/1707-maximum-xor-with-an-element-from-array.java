class Solution {
    class TrieNode{
        TrieNode[] children=new TrieNode[2];

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
    public int getmaxXor(int num){
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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[][] sq=new int[queries.length][3];
        for(int i=0;i<queries.length;i++){
            sq[i][0]=queries[i][0];
                        sq[i][1]=queries[i][1];

            sq[i][2]=i;

        }
        Arrays.sort(sq,(a,b)->Integer.compare(a[1],b[1]));
        int ans[]=new int[queries.length];
int index=0;
        for(int[] q:sq){
            int x=q[0];int m=q[1];
            int idx=q[2];
            while(index<nums.length&&nums[index]<=m){
                insert(nums[index]);
                index++;
            }
            if(index==0){
                ans[idx]=-1;
            }
            else{
                ans[idx]=getmaxXor(x);
            }
        }
    //        int[][] sortedQueries = new int[queries.length][3];

    //     for (int i = 0; i < queries.length; i++) {
    //         sortedQueries[i][0] = queries[i][0]; // x
    //         sortedQueries[i][1] = queries[i][1]; // m
    //         sortedQueries[i][2] = i;             // original index
    //     }

    //     // Sort queries by m
    //     Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[1], b[1]));

    //     int[] answer = new int[queries.length];

    //    TrieNode trie = new TrieNode();

    //     int numsIndex = 0;

    //     for (int[] query : sortedQueries) {

    //         int x = query[0];
    //         int m = query[1];
    //         int originalIndex = query[2];

    //         // Insert all nums <= m
    //         while (numsIndex < nums.length && nums[numsIndex] <= m) {
    //             insert(nums[numsIndex]);
    //             numsIndex++;
    //         }

    //         // No valid number exists
    //         if (numsIndex == 0) {
    //             answer[originalIndex] = -1;
    //         } else {
    //             answer[originalIndex] = getmaxXor(x);
    //         }
    //     }

        return ans;
        
    }
}