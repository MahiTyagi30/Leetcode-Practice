class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int a[]=new int[n];
       Arrays.fill(a,1);
        
        for(int i=1;i<n;i++){
     int c=a[i-1];
     if(ratings[i]>ratings[i-1]){
        a[i]=c+1;
     }
        }

        for(int i=n-2;i>=0;i--){
     int c=a[i+1];
     if(ratings[i]>ratings[i+1]){
        a[i]=Math.max(a[i],c+1);
     }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+a[i];
        }
        return sum;
    }
}