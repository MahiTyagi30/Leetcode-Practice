class Solution {
    public boolean parseBoolExpr(String exp) {
          Stack<Character> st = new Stack<>();
          for(char ch:exp.toCharArray()){
            if(ch==','){
                continue;
            }
            if(ch!=')'){
                st.push(ch);
            }
            else{
                 int tc = 0;
                int fc= 0;
                while(st.peek()
                !='('){
                    char v=st.pop();
                    if(v=='t'){
                        tc++;
                    }
                    else{
                        fc++;
                    }

                }
                st.pop();
                char c=st.pop();
                  char result;
                if(c=='&'){
                   result=(fc>0)?'f':'t';
                }
                  else if (c == '|') {
                    result = (tc > 0) ? 't' : 'f';
                } 
                else { // !
                    result = (tc > 0) ? 'f' : 't';
                }

                // Push result back
                st.push(result);
            }
          
          }
            return st.peek()=='t';
      
    }
}