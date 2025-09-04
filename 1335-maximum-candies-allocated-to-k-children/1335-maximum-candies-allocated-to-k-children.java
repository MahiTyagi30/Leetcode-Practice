class Solution {
    public boolean equalCandies(int[] candies,long k,int mid){
        long c=0;
        for(int i=0;i<candies.length;i++){
            
            if(mid<=candies[i]){
                int a=candies[i]/mid;
                c=c+a;
            }
        }
        return c>=k;


    }
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        int l=1;
        int r=0;
        for(int i=0;i<n;i++){
            r=Math.max(r,candies[i]);
        }
        int res=0;
        while(l<=r){
            int mid=(l+r)/2;

        
        if(equalCandies(candies,k,mid)){
            l=mid+1;
            res=mid;

        }
        else{
            r=mid-1;
        }
        }
        return res;
        
    }
}