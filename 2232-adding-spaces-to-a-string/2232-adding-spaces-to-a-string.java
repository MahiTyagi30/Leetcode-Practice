class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n=spaces.length;
        int l=s.length();
        StringBuilder sb=new StringBuilder(s);
         int offset = 0; // Offset to adjust indices after each insertion
        
        for (int i = 0; i < n; i++) {
            int index = spaces[i] + offset; // Adjust the index based on the offset
            sb.insert(index, ' ');         // Insert space at the adjusted index
            offset++;                      // Increment offset as one character is added
        }
        return sb.toString();
        
    }
}