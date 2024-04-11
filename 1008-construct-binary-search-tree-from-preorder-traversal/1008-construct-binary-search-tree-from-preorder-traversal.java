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
    public TreeNode bst(int[]preorder ,int []idx , int lower , int upper){
        if(idx[0] == preorder.length || preorder[idx[0]]<lower || preorder[idx[0]]>upper) return null;

        TreeNode root = new TreeNode(preorder[idx[0]++]);
        root.left = bst(preorder , idx , lower , root.val) ;
        root.right = bst(preorder , idx  , root.val , upper) ;
        return root ;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] idx = {0} ;
        return bst(preorder ,idx  , Integer.MIN_VALUE , Integer.MAX_VALUE) ;
    }
}