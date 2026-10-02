public class contructBTSFromPreorder {
    
}

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
    private int i = 1;
    private int rootVal;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        rootVal = preorder[0];
        
        // Loop until all elements from preorder are inserted into the BST
        while (i < preorder.length) {
            btsFromPreHelper(root, preorder);
        }
        
        return root;
    }

    public TreeNode btsFromPreHelper(TreeNode node, int[] preorder) {
        if (i >= preorder.length) return node;

        // Global check: left subtree half
        if (preorder[i] < rootVal) {      
            // Local check
            if (preorder[i] < node.val) {     // Smaller than current node -> go left
                if (node.left == null) {
                    node.left = new TreeNode(preorder[i++]);
                } else {
                    btsFromPreHelper(node.left, preorder);
                }
            } else {                           // Fixed missing '{' here!
                if (node.right == null) {     // Bigger than current node -> go right
                    node.right = new TreeNode(preorder[i++]);
                } else {
                    btsFromPreHelper(node.right, preorder);
                }
            }
        } 
        // Global check: right subtree half
        else if (preorder[i] > rootVal) {      
            // Local check
            if (preorder[i] > node.val) {     // Bigger than current node -> go right
                if (node.right == null) {
                    node.right = new TreeNode(preorder[i++]);
                } else {
                    btsFromPreHelper(node.right, preorder);
                }
            } else {                           // Smaller than current node -> go left
                if (node.left == null) {
                    node.left = new TreeNode(preorder[i++]);
                } else {
                    btsFromPreHelper(node.left, preorder);
                }
            }
        }
        
        return node;
    }
}

class Solution2 {   //standard solution
    private int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MAX_VALUE);
    }

    private TreeNode buildBST(int[] preorder, int bound) {
        // Base case: out of elements or current value violates upper bound
        if (i >= preorder.length || preorder[i] > bound) {
            return null;        // current should be smaller than grandparent's value
        }

        // Create the current node
        TreeNode root = new TreeNode(preorder[i++]);

        // Left child must be smaller than current root's value
        root.left = buildBST(preorder, root.val);

        // Right child must be smaller than the parent's upper bound
        root.right = buildBST(preorder, bound);

        return root;
    }
}


