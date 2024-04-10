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
    public List<Integer> helper(TreeNode root , List<Integer> ans){
        if(root==null) return ans ;
        
        helper(root.left , ans);
        ans.add(root.val) ;
        helper(root.right , ans) ;

        return ans ;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>() ; int ans = 1 ;
        helper(root , ls) ;
        return ls.get(k-1) ;
    }
}