class Solution {
    public boolean checkValidString(String s) {
        int l=s.length();
      int min=0;
      int max=0;

       for(int i=0;i<l;i++){
        char ch=s.charAt(i);
        if(ch=='('){
            min++;
            max++;
        }
        else if(ch==')'){
            min=min-1;
            max--;
        }
        else{
            min=min-1;
            max=max+1;
        }
        if(min<0){
            min=0;
        }
        if(max<0){
            return false;
        }
        

       }
       return min==0;

    }
}