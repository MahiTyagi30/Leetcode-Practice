class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        Stack<Integer> st=new Stack<>();
        

        int n=temp.length;
        int ar[]=new int [n];
        int c=0;
        for(int i=n-1;i>=0;i--){
            
            
            while(!st.isEmpty()&& temp[st.peek()]<=temp[i]){
               
                st.pop();
                // c=(!st.isEmpty())?st.peek():-1;
                
            }
            if(st.isEmpty()){
                ar[i]=0;

            }
            else{
c=st.peek();
            ar[i]=c-i;
            c=1;
            }
           
            
            st.push(i);
           
        }
        return ar;
        
    }
}