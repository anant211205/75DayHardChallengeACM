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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>() ;
        Stack<TreeNode> st1 = new Stack<>() ; 
        Stack<TreeNode> st2 = new Stack<>() ;
        if(root == null) return ans ;
        st1.push(root) ; 
        while(!st1.isEmpty() || !st2.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            // for Right to left (st1)
            if(!st2.isEmpty()){
                while(!st2.isEmpty()){
                    TreeNode temp = st2.pop() ;
                    if(temp != null){
                        ls.add(temp.val) ;
                        if(temp.right != null) st1.push(temp.right) ;
                        if(temp.left != null) st1.push(temp.left) ;
                    }
                }
            }

            // for left to right (st2)
            else{
                while(!st1.isEmpty()){
                    TreeNode temp = st1.pop() ;
                    if(temp != null){
                        ls.add(temp.val) ;
                        if(temp.left != null) st2.push(temp.left) ;
                        if(temp.right != null) st2.push(temp.right) ;
                    } 
                }
            }
        ans.add(ls) ;
        }
        return ans; 
    }
}