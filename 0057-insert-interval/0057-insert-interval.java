import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][]  insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res=new ArrayList<>();
        int l=intervals.length;
        int i=0;
        while(i<l&&intervals[i][1]<newInterval[0]){
            res.add(intervals[i++]);
        }
        while(i<l&&intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
             newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
             i++;
        }
        res.add(newInterval);
         while (i < intervals.length) {
            res.add(intervals[i++]);
        }

      int ar[][]=new int[res.size()][2];
      for(int j=0;j<res.size();j++){
        ar[j]=res.get(j);
      }
      return ar;
     
    }
}
