class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.sort(hand);
        int l=hand.length;
        for(int i=0;i<l;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        for(int i=0;i<l;i++){
            int a=hand[i];
            if(map.get(a)==0){
                continue;
            }
            for(int j=0;j<groupSize;j++){
                int curr=a+j;
                if(!map.containsKey(curr)||map.get(curr)==0){
                    return false;
                }
                map.put(curr,map.get(curr)-1);
            }
        }
        return true;

    }
}