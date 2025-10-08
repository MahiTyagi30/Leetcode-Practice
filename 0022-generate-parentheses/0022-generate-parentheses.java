class Solution {
    public static void fun(ArrayList<String> arr,String str,int o,int c,int n){
        if(str.length()==2*n){
            arr.add(str);
            return;

        }
        if(o>0){
          fun(arr,str+"(",o-1,c,n);
        }
         if(c>o){
          fun(arr,str+")",o,c-1,n);
        }
    }
  
    public List<String> generateParenthesis(int n) {
      int o=n;
      int c=n;
      ArrayList<String> arr=new ArrayList<>();
       fun(arr,"(",o-1,c,n);
       return arr;
    }
}