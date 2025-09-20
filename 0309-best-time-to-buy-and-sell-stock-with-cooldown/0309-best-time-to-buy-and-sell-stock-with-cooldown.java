import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String ,Integer> map=new HashMap<>();
        return dfs(0,true,prices,map);
        
    }
    public int dfs(int i,boolean buying,int[] prices,Map<String, Integer> map){
        if(i>=prices.length){
            return 0;
        }
        String key=i+","+buying;
        if (map.containsKey(key)) return map.get(key);
        int res=0;
        int cooldown=dfs(i+1,buying,prices,map);
        if(buying){
            int buy=dfs(i+1,false,prices,map)-prices[i];
            res=Math.max(buy,cooldown);
        }
        else{
            int sell=dfs(i+2,true,prices,map)+prices[i];
            res=Math.max(sell,cooldown);

        }
         map.put(key, res);
        return res;
    }
}