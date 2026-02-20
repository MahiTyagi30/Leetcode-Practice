class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l=cardPoints.length;
        // int i=0;
        int j=l-1;
        int c=0;
        int lsum=0;
        int rsum=0;
        int m=-1;

        for(int i=0;i<k;i++){
            lsum=lsum+cardPoints[i];
        }
        m=lsum;
        for(int i=k-1;i>=0;i--){
            lsum=lsum-cardPoints[i];
            rsum=rsum+cardPoints[j];
            j--;
          m=Math.max(lsum+rsum,m);
        }
        return m;
    }
}