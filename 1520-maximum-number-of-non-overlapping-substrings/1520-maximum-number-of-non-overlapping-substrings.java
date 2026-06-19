import java.util.*;

class Solution {
    
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';

            if (first[ch] == -1) {
                first[ch] = i;
            }
            last[ch] = i;
        }

        List<String> result = new ArrayList<>();
        int prevEnd = -1;

        for (int i = 0; i < n; i++) {

            // Only start from first occurrence
            if (i != first[s.charAt(i) - 'a']) {
                continue;
            }

            int end = getValidEnd(s, i, first, last);

            if (end == -1) {
                continue;
            }

            if (i > prevEnd) {
                result.add(s.substring(i, end + 1));
            } else {
                // Replace previous with smaller substring
                result.set(
                    result.size() - 1,
                    s.substring(i, end + 1)
                );
            }

            prevEnd = end;
        }

        return result;
    }

    private int getValidEnd(String s, int start,
                            int[] first, int[] last) {

        int end = last[s.charAt(start) - 'a'];

        for (int i = start; i <= end; i++) {

            int ch = s.charAt(i) - 'a';

            // Character started before current substring
            if (first[ch] < start) {
                return -1;
            }

            end = Math.max(end, last[ch]);
        }

        return end;
    }
}