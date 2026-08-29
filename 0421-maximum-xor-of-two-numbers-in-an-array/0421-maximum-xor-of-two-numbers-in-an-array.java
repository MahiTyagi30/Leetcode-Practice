class Solution {

    class Node {
        Node[] child = new Node[2];
    }

    Node root = new Node();

    void insert(int num) {
        Node curr = root;

        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (curr.child[bit] == null) {
                curr.child[bit] = new Node();
            }

            curr = curr.child[bit];
        }
    }

    int getMaxXor(int num) {
        Node curr = root;
        int xor = 0;

        for (int i = 30; i >= 0; i--) {

            int bit = (num >> i) & 1;

            // We want opposite bit
            int opposite = 1 - bit;

            if (curr.child[opposite] != null) {
                xor = xor | (1 << i);
                curr = curr.child[opposite];
            } else {
                curr = curr.child[bit];
            }
        }

        return xor;
    }

    public int findMaximumXOR(int[] nums) {

        // Insert all numbers
        for (int num : nums) {
            insert(num);
        }

        int ans = 0;

        // Find best XOR for every number
        for (int num : nums) {
            ans = Math.max(ans, getMaxXor(num));
        }

        return ans;
    }
}