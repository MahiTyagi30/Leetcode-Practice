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
    public static int fun(TreeNode root){
        if(root==null){
            return 0;
        }
        int a=1+fun(root.left);
        int b=1+fun(root.right);
        return Math.max(a,b);
    }
   
    public int maxDepth(TreeNode root) {
        return fun(root);
         
     
    }
}