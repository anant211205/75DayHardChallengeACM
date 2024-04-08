class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            // Leaf node or node with one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with both children
            TreeNode parent = root;
            TreeNode child = root.right;
            while (child.left != null) {
                parent = child;
                child = child.left;
            }
            if (parent != root) {
                parent.left = child.right;
                child.left = root.left;
                child.right = root.right;
                return child;
            } else {
                child.left = root.left;
                return child;
            }
        }
    }
}
