import java.util.*;

class Solution {
    private void fun(List<String> result,StringBuilder sb,int index,String [] ar,String digits){
        if(index==digits.length()){
            result.add(sb.toString());
            return;
        }
        int num=digits.charAt(index)-'0';
        String value=ar[num-2];
        for(int i=0;i<value.length();i++){
            sb.append(value.charAt(i));
            fun(result,sb,index+1,ar,digits);
           sb.deleteCharAt(sb.length() - 1);

        }
    }
 

    public List<String> letterCombinations(String digits) {
        String[] ar = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        int l=digits.length();
        if(l==0){
            return result;
        }
        int index=0;
        StringBuilder sb=new StringBuilder("");
        fun(result,sb,index,ar,digits);
        return result;
        
    }
}
