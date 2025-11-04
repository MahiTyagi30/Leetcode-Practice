class Solution {
    public int characterReplacement(String s, int k) {
        int freq[]=new int[26];
        int maxfreq=0;
        int len=s.length();
        int l=0;
int mlen=0;
        for(int r=0;r<len;r++){
            freq[s.charAt(r)-'A']++;
             maxfreq=Math.max(maxfreq,freq[s.charAt(r)-'A']);
             while((r-l+1)-maxfreq>k){
                freq[s.charAt(l)-'A']--;
                l++;


             }
             mlen = Math.max(mlen, r - l + 1);
        }
       
        return mlen;

        }
        
    }
