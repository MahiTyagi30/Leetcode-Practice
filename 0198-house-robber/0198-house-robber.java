class Solution {
    public int rob(int[] nums) {
        
int n=nums.length;
int[] dp=new int[n];
dp[0]=nums[0];
// dp[1]=nums[1];

for(int i=1;i<n;i++){
     int a=Integer.MIN_VALUE;
if( i-2<0){
        
  a=nums[i]+0;
    
    }
    else{
       a=nums[i]+dp[i-2];;
    }
   
   int b=dp[i-1];
    dp[i]=Math.max(a,b);
}
     return dp[n-1];   

       }


}