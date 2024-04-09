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
    public void minDist(TreeNode root , int []prev , int []ans){
        if(root == null) return  ;
        minDist(root.left , prev , ans);
        if(prev[0]!=Integer.MIN_VALUE){
            ans[0] = Math.min(ans[0] , root.val - prev[0]) ;
        }
        prev[0] = root.val ;
        minDist(root.right , prev, ans) ;
    }
    public int minDiffInBST(TreeNode root) {
        int prev[] = {Integer.MIN_VALUE};
        int ans[] = {Integer.MAX_VALUE}; 
        minDist(root,prev,ans) ;
        return ans[0] ;
    }
}