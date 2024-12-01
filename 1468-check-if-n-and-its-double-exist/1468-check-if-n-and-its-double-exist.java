class Solution {
    public boolean checkIfExist(int[] arr) {
      HashSet<Integer> h = new HashSet<>();
        int zeroCount = 0;

        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            }
            h.add(num);
        }

        if (zeroCount > 1) { // If there are at least two zeros
            return true;
        }

        for (int num : arr) {
            if (num != 0 && h.contains(2 * num)) {
                return true;
            }
        }

        return false;
    }
}