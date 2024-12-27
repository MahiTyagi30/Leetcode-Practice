class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // Sort by 1st index if 0th indices are equal
            }
            return Integer.compare(a[0], b[0]); // Sort by 0th index
        });
         int[] curr=intervals[0];
         int c=0;
         for(int i=1;i<intervals.length;i++){
            int currEnd=curr[1];
            int nextStart=intervals[i][0];
            int nextEnd=intervals[i][1];
            if(nextStart<currEnd){
                c++;
            }
            else{
                curr=intervals[i];
            }
         }
         return c;
    }
}