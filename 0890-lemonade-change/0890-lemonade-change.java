class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f=0;
        int t=0;
        for(int i=0;i<bills.length;i++){
            int a=bills[i];

            if(a==5){
                f++;

            }
            else if(a==10){
                t++;
                if(f>=1){
                    f--;
                }
                else{
                    return false;
                }
            }
            else{
                if(t>=1&&f>=1){
                    f--;
                    t--;
                }
                else if(f>=3){
                    f=f-3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
        
    }
}