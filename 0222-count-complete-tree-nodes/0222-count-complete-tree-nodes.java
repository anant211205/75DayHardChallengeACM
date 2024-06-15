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

    public int getLeftHt(TreeNode root){
        TreeNode temp = root ;
        int lh = 0 ;

        while(temp != null){
            temp = temp.left ;
            lh++ ;
        }

        return lh ;
    }
    public int getRightHt(TreeNode root){
        TreeNode temp = root ;
        int rh = 0 ;

        while(temp != null){
            temp = temp.right ;
            rh++ ;
        }

        return rh ;
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0; 

        int lh = getLeftHt(root) ;
        int rh = getRightHt(root) ;

        if(lh == rh){  //prefect binary tree
            return (int) (Math.pow(2 , lh) - 1) ;
        }

        return 1 + countNodes(root.left) + countNodes(root.right) ;
    }
}