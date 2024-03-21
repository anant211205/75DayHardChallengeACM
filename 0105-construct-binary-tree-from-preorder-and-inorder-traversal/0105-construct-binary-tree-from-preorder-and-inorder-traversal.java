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
    public int findPos(int[] inOrder , int target , int inStart , int inEnd){
        for(int i=inStart ;i<=inEnd ;i++){
            if(inOrder[i] == target){
                return i ;
            }
        }
        return -1 ;
    }

    public TreeNode helper(int[] preOrder , int[]inOrder , int inStart , int inEnd , int index){
        if(inStart>inEnd || index >= preOrder.length) return null ;

        TreeNode root = new TreeNode(preOrder[index]); 
        int pos = findPos(inOrder , preOrder[index] , inStart , inEnd);
        root.left = helper(preOrder,inOrder,inStart,pos-1,index+1);
        root.right = helper(preOrder,inOrder,pos+1,inEnd,index+(pos-inStart)+1);
        return root ;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode ans = helper(preorder , inorder,0,inorder.length,0) ;
        return ans ;
    }
}