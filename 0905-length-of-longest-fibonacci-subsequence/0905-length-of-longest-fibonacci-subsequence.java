class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        
        HashMap<Integer,Integer> h=new HashMap<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            h.put(arr[i],i);
        }
        int maxi=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int k=arr[j];
                int m=arr[i];
                int len=2;
                while(h.containsKey(k+m)){
                    len++;
                    maxi=Math.max(maxi,len);
                    int t=k;
                    k=k+m;
                    m=t;
                }
            }
        }
        return maxi > 2 ? maxi : 0;
    }
}