class Solution {
    public long continuousSubarrays(int[] nums) {
        int i=0;
        long sub=0;
        TreeMap<Integer,Integer> t=new TreeMap<>();
        for(int j=0;j<nums.length;j++){
     t.put(nums[j],t.getOrDefault(nums[j],0)+1);
     while(t.lastKey()-t.firstKey()>2){
        t.put(nums[i],t.get(nums[i])-1);
        if(t.get(nums[i])==0){
            t.remove(nums[i]);
        }
        i++;
     }
     sub=sub+(j-i+1);
        }
        return sub;
    }
}