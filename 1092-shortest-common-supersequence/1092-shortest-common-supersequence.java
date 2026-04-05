class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int l1=text1.length();
      int l2=text2.length();
      int dp[][]=new int[l1+1][l2+1];
      for(int i=1;i<=l1;i++){
        for(int j=1;j<=l2;j++){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
            }
            else{
                 dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
      }
                  int i=dp.length-1;
            int j=dp[0].length-1;

StringBuilder sb=new StringBuilder();
while(i>0&&j>0){
    if(text1.charAt(i-1)==text2.charAt(j-1)){
        sb.append(text1.charAt(i-1));
        i--;
        j--;

    }
    else if(dp[i-1][j]>dp[i][j-1]){
        sb.append(text1.charAt(i-1));
        i--;
    }
    else {
        sb.append(text2.charAt(j-1));
        j--;
    }
}
while(i>0){
    sb.append(text1.charAt(i-1));
    i--;
}
while(j>0){
    sb.append(text2.charAt(j-1));
    j--;
}
return sb.reverse().toString();
      
    }
}