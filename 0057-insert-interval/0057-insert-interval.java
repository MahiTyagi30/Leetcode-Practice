import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][]  insert(int[][] intervals, int[] newInterval) {
       ArrayList<int[]> res=new ArrayList<>();
       int i=0;
       int l=intervals.length;
       while(i<l&&intervals[i][1]<newInterval[0]){
        res.add(intervals[i]);
        i++;
       }
       while(i<l&&intervals[i][0]<=newInterval[1]){
        newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
          newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
          i++;
       }
       res.add(newInterval);
       while(i<l){
        res.add(intervals[i]);
        i++;
       }
       int ar[][]=new int[res.size()][2];
       for(int j=0;j<res.size();j++){
        ar[j]=res.get(j);
       }
       return ar;
    }
}
