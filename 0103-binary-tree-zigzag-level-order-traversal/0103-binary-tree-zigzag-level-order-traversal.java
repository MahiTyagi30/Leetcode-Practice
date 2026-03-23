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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> l = new ArrayList<>();

        if (root == null) {
            return l;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        boolean leftToRight = true; // ✅ added

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> sub = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                TreeNode node = q.poll(); 

                
                if (leftToRight) {
                    sub.add(node.val);
                } else {
                    sub.add(0, node.val);
                }

                
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            l.add(sub);
            leftToRight = !leftToRight; 
        }

        return l;


                }

               
        
    
}