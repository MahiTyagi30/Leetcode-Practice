class Solution {
   public void fun(String s,int op,int cl,int n,ArrayList<String> list){
   
    if(s.length()==2*n){
        list.add(s);
        return ;
        
    }
    if(op<n){
 fun(s+"(",op+1,cl,n,list);
    }
   
    if(cl<op){
        fun(s+")",op,cl+1,n,list);
    }
   

   }
    public List<String> generateParenthesis(int n) {
      int o=n;
      int c=n;
       ArrayList<String> list=new ArrayList<>();
      fun("(",1,0,n,list);
      return list;
    }
}