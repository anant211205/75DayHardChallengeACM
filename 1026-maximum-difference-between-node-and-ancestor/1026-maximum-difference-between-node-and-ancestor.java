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
    public int maxDiff(TreeNode root , int max , int min){
        if(root == null){
            return Math.abs(max-min) ;
        }

        max = Math.max(max , root.val) ;
        min = Math.min(min , root.val) ;

        int left = maxDiff(root.left , max , min) ;
        int right = maxDiff(root.right , max , min) ;

        return Math.max(left , right) ;


    }
    public int maxAncestorDiff(TreeNode root) {
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE ;

        return maxDiff(root , max , min) ;
    }
}