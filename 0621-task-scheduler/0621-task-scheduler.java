class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq=-1;
        int l=tasks.length;
        char freq[]=new char[26];

        for(int i=0;i<l;i++){
            char ch=tasks[i];
            freq[ch-'A']++;
            maxFreq=Math.max(maxFreq,freq[ch-'A']);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int c:freq){
            if(c>0){
 pq.add(c);
            }
           
        }
        int time=0;
        while(!pq.isEmpty()){

            int cycle = n+1;
            List<Integer> temp=new ArrayList<>();
            while(cycle>0&&!pq.isEmpty()){
                int count=pq.poll();
                if (count > 1) {
                    temp.add(count - 1);
                }

                time++;
                cycle--;
            }
            for(int t:temp){
                pq.add(t);
            }
            if(!pq.isEmpty()){
                time=time+cycle;
            }
        }
        return time;

        
    }
}