/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

      private HashSet<Integer> values;
    
    private void recover(TreeNode node, int val) {
        if (node == null) return;
        node.val = val;
        values.add(val);
        recover(node.left, 2 * val + 1);
        recover(node.right, 2 * val + 2);
    }
    
    public FindElements(TreeNode root) {
        values = new HashSet<>();
        if (root != null) {
            recover(root, 0);
        }
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }

}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */