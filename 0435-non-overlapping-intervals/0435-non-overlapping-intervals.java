import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals,(a,b)->a[1]-b[1]);
       int prevEnd=intervals[0][1];
       int c=0;
       int l=intervals.length;
       for(int i=1;i<l;i++){
        if(intervals[i][0]<prevEnd){
            c++;
        }
        else{
            prevEnd=intervals[i][1];
        }
       }
       return c;
    }
}
