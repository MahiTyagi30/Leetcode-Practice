class Solution {
    public int minimumCardPickup(int[] cards) {
        HashSet<Integer> set=new HashSet<>();
        int l=cards.length;
        int i=0;
        int m=Integer.MAX_VALUE;
        int flag=0;
        for(int j=0;j<l;j++){
            while(set.contains(cards[j])){
                m=Math.min(m,j-i+1);
                flag=1;
                set.remove(cards[i]);
                i++;
            }
            set.add(cards[j]);
        }
        if(flag==0){
            return -1;
        }
        return m;
        
    }
}