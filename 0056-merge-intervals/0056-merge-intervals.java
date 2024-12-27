import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
       if(intervals.length<=1){
        return intervals;
       }
       ArrayList<int[]> res=new ArrayList<>();
       Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
       int[] curr=intervals[0];
       res.add(curr);
       for(int i=0;i<intervals.length;i++){
        int currEnd=curr[1];
        int nextStart=intervals[i][0];
        int nextEnd=intervals[i][1];
        if(nextStart<=currEnd){
            curr[1]=Math.max(nextEnd,currEnd);
        }
        else{
            curr=intervals[i];
            res.add(curr);
        }
       }
        return res.toArray(new int[res.size()][]);
    }
}
