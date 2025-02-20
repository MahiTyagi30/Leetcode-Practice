class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;

        
        Set<String> s=new HashSet<>();
        for(String num:nums){
            s.add(num);
        }

        for(int i=0;i<(1<<n);i++){
            StringBuilder sb=new StringBuilder();
            for(int j=n-1;j>=0;j--){
                sb.append((i&(1<<j))!=0?1:0);
            }
             String candidate = sb.toString();
            if (!s.contains(candidate)) {
                return candidate;
            }
        }
        return "";
    }
}