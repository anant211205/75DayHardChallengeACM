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

    public void solve(TreeNode root , int currMax , int[] count){
        if(root == null) return ;

        if(root.val >= currMax){
            currMax = root.val ;
            count[0]++ ;
        }

        solve(root.left ,currMax, count) ;
        solve(root.right ,currMax, count) ;

    }

    public int goodNodes(TreeNode root) {
        int[] count = {0} ;
        if(root == null) return 1 ;
        solve(root , root.val ,count) ;
        return count[0]; 
    }
}