class Solution {
    private long minVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true; 
        //checking left
        if (!isValidBST(root.left)) return false;
        
        //checking root
        if (minVal >= root.val) return false; 

        minVal = root.val;
        //checking right
        if (!isValidBST(root.right)) return false;

        return true;
    } 
}