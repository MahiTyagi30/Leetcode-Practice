class Solution {
    public int characterReplacement(String s, int k) {
       int l=s.length();
       int i=0;
       int j=0;
       int [] map=new int[26];
       int mxfreq=0;
       int mxlen=-1;
       while(j<l){
               char c = s.charAt(j);
               map[c-'A']++ ;
               mxfreq=Math.max(mxfreq,map[c-'A']);
                if((j-i+1)-mxfreq>k){
                    map[s.charAt(i)-'A']--;
                    i++;
                }
                if((j-i+1)-mxfreq<=k){
                    mxlen=Math.max(j-i+1,mxlen);
                }
                j++;

               
       }
       return mxlen;

        }
        
    }
