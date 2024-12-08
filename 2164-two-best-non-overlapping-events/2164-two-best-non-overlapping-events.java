import java.util.Arrays;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort events by end time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int maxVal=0;
        int ans=0;
        for(int[] event:events){
            int s=event[0];
            int e=event[1];
            int w=event[2];
            while(!pq.isEmpty()&&pq.peek()[0]<s){
                maxVal=Math.max(maxVal,pq.poll()[1]);
            }
            ans=Math.max(ans,maxVal+w);
            pq.add(new int[]{e,w});
        }
        return ans;
    }
}
