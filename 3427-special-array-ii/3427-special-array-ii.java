class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        // boolean[] o = new boolean[nums.length];
        boolean[] res = new boolean[queries.length];
        // Set<Integer> s = new HashSet<>();
int c=0;
       int pre[]=new int[n];
       for(int i=1;i<n;i++){
        if(nums[i]%2!=nums[i-1]%2){
            c++;
        }
        pre[i]=c;
       }
       for(int i=0;i<queries.length;i++){
        res[i]=true;
        if(pre[queries[i][1]]-pre[queries[i][0]]!=queries[i][1]-queries[i][0]){
            res[i]=false;
        }
       }
        return res;
    }
}
