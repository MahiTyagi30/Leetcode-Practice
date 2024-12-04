class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;

        while (j < str2.length()) {
            if (i == str1.length()) {
                return false; // If str1 is exhausted before matching all of str2
            }

            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);

            // Check if ch1 can be incremented circularly to match ch2
            if ((ch1 == ch2) || ((ch1 - 'a' + 1) % 26 == (ch2 - 'a'))) {
                j++; // Match found, move to the next character in str2
            }
            i++; // Always move to the next character in str1
        }

        return true; // If all characters in str2 are matched
    }
}
