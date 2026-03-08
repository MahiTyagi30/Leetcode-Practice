class Solution {
    public boolean isValid(String s) {
       int l=s.length();
       Stack<Character> st=new Stack<>();
       for(int i=0;i<l;i++){
        char ch=s.charAt(i);
        if(ch=='('||ch=='{'||ch=='['){
            st.push(ch);
            continue;
        }
        else{
             if (st.isEmpty()) return false;
              if(ch==')' && st.peek()=='('){
            st.pop();
        }
        else if(ch=='}' && st.peek()=='{'){
            st.pop();
        }
        else if(ch==']' && st.peek()=='['){
            st.pop();
        }
        else{
            return false;
        }
        }
        
       }
        return st.isEmpty();
    }
}