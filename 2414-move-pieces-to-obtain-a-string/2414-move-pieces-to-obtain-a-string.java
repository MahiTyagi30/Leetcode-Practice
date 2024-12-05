class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        int n = start.length();

        while (i < n || j < n) {
            // Skip underscores in both strings
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            // If one pointer reaches the end before the other
            if (i == n || j == n) {
                return i == j; // Both must finish at the same time
            }

            // Check if characters at current positions are the same
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            // Check invalid moves for 'L' and 'R'
            if (start.charAt(i) == 'L' && i < j) {
                return false; // 'L' cannot move right
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false; // 'R' cannot move left
            }

            i++;
            j++;
        }

        return true;
    }
}
