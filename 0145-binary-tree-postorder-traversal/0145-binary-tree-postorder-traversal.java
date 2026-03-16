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
    public static void fun(TreeNode root ,ArrayList<Integer> l){
        if(root==null){
            return;
        }
       fun(root.left,l);
        
        fun(root.right,l);
        l.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
         ArrayList<Integer> l=new ArrayList<>();
        fun(root,l);
        return l;
        
    }
}