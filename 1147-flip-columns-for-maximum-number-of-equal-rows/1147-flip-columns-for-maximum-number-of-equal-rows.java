class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {    
        Map<String, Integer> pat = new HashMap<>();
       for(int[] row:matrix){
        StringBuilder s1=new StringBuilder();
        StringBuilder s2 =new StringBuilder();
        for(int r:row){
            s1.append(r);
            s2.append(1-r);
        }

        String s11=s1.toString();
        String s22=s2.toString();
        pat.put(s11,pat.getOrDefault(s11,0)+1);
        pat.put(s22,pat.getOrDefault(s22,0)+1);
       }
        int maxFrequency = 0;
        for (int freq : pat.values()) {
            maxFrequency = Math.max(freq, maxFrequency);
        }
        return maxFrequency;
    }
}