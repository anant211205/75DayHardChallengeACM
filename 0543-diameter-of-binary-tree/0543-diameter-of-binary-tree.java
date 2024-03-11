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
    //here diameter is passed by refernce
    public int height(TreeNode root , int[] diameter){
        if(root == null) return 0 ;
        int lh = height(root.left , diameter);
        int rh = height(root.right , diameter);
        diameter[0] = Math.max(diameter[0] , lh + rh);
        return (1 + Math.max(rh ,lh));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        //optimal (o(n)->tc , o(n)-> sc)
        int[] diameter = new int[1];
        height(root , diameter) ;
        return diameter[0] ;

        //o(n^2)
        // int max = 0 ;
        // int lh = height(root.left) ;
        // int rh = height(root.right) ;
        // max = Math.max(max , lh + rh) ;
        // diameterOfBinaryTree(root.left) ;
        // diameterOfBinaryTree(root.right) ;
        // return max ; 

        // if(root == null) return 0 ;
        // int ld = diameterOfBinaryTree(root.left) ;
        // int lh = height(root.left) ;
        // int rd = diameterOfBinaryTree(root.right) ;
        // int rh = height(root.right) ;

        // int selfDiameter = lh + rh ;

        // return Math.max(selfDiameter , Math.max(ld , rd)) ;

    }
}