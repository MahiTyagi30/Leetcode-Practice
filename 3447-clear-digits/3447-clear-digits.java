class Solution {
    public String clearDigits(String s) {
       StringBuilder sb=new StringBuilder(s);
       int c=0;
       while(c<sb.length()){
        if(Character.isDigit(sb.charAt(c))){
            sb.deleteCharAt(c);
            if(c>0){
                sb.deleteCharAt(c-1);
                c--;
            }
        }
            else{
                c++;
            }
        
       } 
       return sb.toString();
    }
}