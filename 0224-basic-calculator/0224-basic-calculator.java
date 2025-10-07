import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch=='+'){
                result += sign*num;
                num=0;
                sign=1;
            }
            else if(ch=='-'){
                result += sign*num;
                num=0;
                sign=-1;
            }
            else if(ch=='('){
               st.push(result);
               st.push(sign);
               result=0;
               sign=1;
            }
            else if(ch==')'){
              result += sign*num;
               num = 0;
              result *= st.pop();
              result += st.pop();

            }
           

        }
         result += sign*num;
            return result;

            
    }
}
