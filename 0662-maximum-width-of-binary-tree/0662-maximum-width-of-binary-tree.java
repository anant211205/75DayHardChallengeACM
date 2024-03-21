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
    class Pair{
        TreeNode node ;
        int index ;

        Pair(TreeNode node , int index){
            this.node = node ;
            this.index = index ;
        }

    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 1 ;
        int ans = 0 ;
        Queue<Pair> que = new LinkedList<>() ;
        que.add(new Pair(root , 0)) ;
        while(!que.isEmpty()){
            int fIdx = 0 , lIdx = 0 ;
            int minIdx = que.peek().index ;
            int qSize = que.size() ;

            for(int i=0;i<qSize;i++){
                int currIdx = que.peek().index-minIdx ;
                TreeNode temp = que.peek().node ;
                que.poll() ;

                if(i==0) fIdx = currIdx ;
                if(i==qSize-1) lIdx = currIdx ;

                if(temp.left != null) que.add(new Pair(temp.left , currIdx*2+1)) ;
                if(temp.right != null) que.add(new Pair(temp.right , currIdx*2+2)) ;

            }
            ans = Math.max(ans , lIdx - fIdx + 1) ;
        }
        return ans ;
    }
}