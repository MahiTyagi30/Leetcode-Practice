class Solution {
    public int candy(int[] ar) {
        
        int sum=0;
        int l=ar.length;
        int candy[]=new int[l];
        Arrays.fill(candy,1);
        
            for(int i=1;i<l;i++){
                if(ar[i]>ar[i-1]){
                    candy[i]=candy[i-1]+1;
                }

            }
            for(int i=l-2;i>=0;i--){
                if(ar[i]>ar[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);
                }
            }
            for(int c:candy){
                sum=sum+c;
            }
            return sum;

        }
    }
