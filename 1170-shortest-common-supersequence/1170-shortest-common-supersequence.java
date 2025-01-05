class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
         int [][] dp= new int [str1.length()+1][str2.length()+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0 ){
                    dp[i][j]=0;
                } 
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
            int i=dp.length-1;
            int j=dp[0].length-1;
            StringBuilder sb=new StringBuilder("");
            while(i>0&&j>0){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    sb.append(str1.charAt(i-1));
                    i--;
                    j--;
                }
                else if(dp[i-1][j]>dp[i][j-1]){
                    sb.append(str1.charAt(i-1));
                    i--;
                }
                else{
                    sb.append(str2.charAt(j-1));
                    j--;
                }
            }
             while(i>0){
            
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}