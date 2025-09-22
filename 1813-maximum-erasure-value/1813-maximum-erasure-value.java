import java.util.*;
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        HashSet<Integer> mp=new HashSet<>();
        int l=nums.length;
        int i=0;
        int sum=0;
        int m=-1;
        for(int j=0;j<l;j++){
           while(mp.contains(nums[j])){
            mp.remove(nums[i]);
            sum=sum-nums[i];
            i++;
           }
           mp.add(nums[j]);
           sum=sum+nums[j];
           m=Math.max(m,sum);
        }
        return m;
    }
}