class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int l=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int i=0;
        int maxfre=0;
        int res=0;
        for(int j=0;j<l;j++){
            int ch=nums[j];
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxfre=Math.max(maxfre,map.getOrDefault(1, 0));
            while((j-i+1)-maxfre>k){
                int ch2=nums[i];
                map.put(ch2,map.get(ch2)-1);
                i++;
            }
            res=Math.max(res,j-i+1);
        }
        return res;
        
    }
}