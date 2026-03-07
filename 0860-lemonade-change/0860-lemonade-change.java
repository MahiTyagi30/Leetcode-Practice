class Solution {
    public boolean lemonadeChange(int[] bills) {
       int l=bills.length;
       int a=0;int b=0;int c=0;

       for(int i=0;i<l;i++){
       if(bills[i]==5){
        a++;
       }
       else if(bills[i]==10){
        if(a>0){
            a--;
            b++;
        }
        else{
            return false;
        }
       }
       else if(bills[i]==20){
        if(b>0){
            b--;
            c++;
            if(a>0){
                a--;

            }
            else{
                return false;
            }
        }
        else if (a>=3){
            a=a-3;
            c++;
        }
        else{
            return false;
        }
       }
       }
       return true;
        
    }
}