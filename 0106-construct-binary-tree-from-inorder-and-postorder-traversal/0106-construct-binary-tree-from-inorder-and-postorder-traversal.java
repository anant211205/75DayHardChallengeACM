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

    public TreeNode helper(int[] postOrder , int[]inOrder , int inStart , int inEnd , int index){
        if(inStart>inEnd || index >= postOrder.length) return null ;

        TreeNode root = new TreeNode(postOrder[index]); 
        int pos = findPos(inOrder , postOrder[index] , inStart , inEnd);
        root.right = helper(postOrder,inOrder,pos+1,inEnd,index-1);
        root.left = helper(postOrder,inOrder,inStart,pos-1,index-(inEnd-pos)-1);
        return root ;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode ans = helper(postorder , inorder,0,inorder.length - 1,postorder.length - 1) ;
        return ans ;
    }
}