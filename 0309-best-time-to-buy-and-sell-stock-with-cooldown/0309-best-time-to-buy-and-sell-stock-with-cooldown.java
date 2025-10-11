import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String ,Integer> map=new HashMap<>();
        int sum=0;
        return dfs(0,true,prices,map);
        
    }
    public static int dfs(int i,Boolean buy,int[] prices,HashMap<String,Integer> map){
        if(i>=prices.length){
            return 0;
        }
        int res=0;
        String key=i+","+buy;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int cool=dfs(i+1,buy,prices,map);
        if(buy){
            int b=dfs(i+1,false,prices,map)-prices[i];
            res=Math.max(b,cool);
        }
        else{
            int s=dfs(i+2,true,prices,map)+prices[i];
            res=Math.max(s,cool);
        }
        map.put(key,res);
        return res;

      
        
    }
   
    
}