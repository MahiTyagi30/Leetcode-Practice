import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
         ArrayList<int[]> res=new ArrayList<>();
        int l=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] curr=intervals[0];
        res.add(curr);
        for(int i=1;i<l;i++){
            int currEnd=curr[1];
            int nextstart=intervals[i][0];
            int nextend=intervals[i][1];
            if(currEnd>=nextstart){
                curr[1]=Math.max(curr[1], intervals[i][1]);

            }
            else{
                curr=intervals[i];
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
      
    }

}
