import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
      
        HashMap<Character, Integer> m1 = new HashMap<>(); // Need
        HashMap<Character, Integer> m2 = new HashMap<>(); // Window
        
        // Build need map
        for (char ch : t.toCharArray()) {
            m1.put(ch, m1.getOrDefault(ch, 0) + 1);
        }
        
        int need = m1.size();  // Number of unique characters needed
        int have = 0;          // Number of characters currently satisfied
        int l = 0, minLen = Integer.MAX_VALUE, startIdx = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            m2.put(ch, m2.getOrDefault(ch, 0) + 1);
            
            // If this character is needed and now fully satisfied
            if (m1.containsKey(ch) && m1.get(ch).intValue() == m2.get(ch).intValue()) {
                have++;
            }
            
            // Try to shrink window while valid
            while (have == need) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }
                
                char c = s.charAt(l);
                m2.put(c, m2.get(c) - 1);
                
                // If we lost a fully satisfied char
                if (m1.containsKey(c) && m2.get(c) < m1.get(c)) {
                    have--;
                }
                l++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
