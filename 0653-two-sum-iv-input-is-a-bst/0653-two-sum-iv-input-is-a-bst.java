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
    public boolean findTarget(TreeNode root, int target) {
        List<Integer> ls = new ArrayList<>(); 
        helper(root , ls); 
        Collections.sort(ls);
        int left = 0 ; int right = ls.size() - 1 ;
        while( left < right){
            int sum = ls.get(left) + ls.get(right) ;
            if(sum < target){
                left++ ;
            }
            else if(sum > target){
                right-- ; 
            }
            else if(sum == target){
                return true;
            }
        }
        return false;
    }
}