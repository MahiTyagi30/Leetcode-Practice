class Solution {
    public List<List<Integer>> threeSum(int[] nums) {//a+b+c=0

int n=nums.length;

    Arrays.sort(nums);
    List<List<Integer>> list=new ArrayList<>();
    for(int i=0;i<n-1;i++){
        if(i>0&&nums[i]==nums[i-1]) continue;
        int l=i+1;
        int r=n-1;
        while(l<r){
            int sum=nums[l]+nums[r]+nums[i];
            if(sum>0){
                r--;
            }
            else if(sum<0){
                l++;
            }
            else{
                List<Integer> triplet =Arrays.asList(nums[i],nums[l],nums[r]);
                list.add(triplet);
                while(l<r&&nums[l+1]==nums[l]){
                    l++;
                }
                while(l<r&&nums[r-1]==nums[r]){
                    r--;
                }
                l++;
                r--;
            }
        }
    }
    return list;
               
    }
}