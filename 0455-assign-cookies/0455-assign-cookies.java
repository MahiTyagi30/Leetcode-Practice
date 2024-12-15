class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n=g.length;
        int m=s.length;
        int c=0;
        int j=0;
       for (int i = 0; i < n && j < m; i++) {
            while (j < m) {
                if (g[i] <= s[j]) {
                    c++;
                    j++;
                    break;
                } 
                j++;
            }
        }
        return c;
    }
}