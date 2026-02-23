import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        while (j < s.length()) {

            char endChar = s.charAt(j);

            if (map.containsKey(endChar)) {
                if (map.get(endChar) > 0) {
                    count++;
                }
                map.put(endChar, map.get(endChar) - 1);
            }

            while (count == t.length()) {

                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    startIndex = i;
                }

                char startChar = s.charAt(i);

                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        count--;
                    }
                }

                i++;
            }

            j++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}