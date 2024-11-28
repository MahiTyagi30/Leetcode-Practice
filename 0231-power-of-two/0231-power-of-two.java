class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n%2==0){
while(n>1&&n%2==0){
        n=n/2;
       }
       
        }
       
        if(n==1){
            return true;
        }

        return false;
        
    }
}