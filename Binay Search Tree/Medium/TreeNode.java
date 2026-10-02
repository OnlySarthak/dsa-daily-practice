public class TreeNode {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)  return new TreeNode(val);   // base case
        
        if (val > root.val ) {
            if(root.right != null)insertIntoBST(root.right, val);
            else root.right = new TreeNode(val);
        } else {
            if(root.left != null)insertIntoBST(root.left, val);
            else root.left = new TreeNode(val);
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            // If right subtree is missing, return left subtree directly
            if (root.right == null) return root.left;
            // Attach left subtree to the right subtree and return right subtree as new root
            insertIntoBST(root.right, root.left);
            return root.right;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, TreeNode node) {
        if (root == null) return node;
        if (node == null) return root;

        if (node.val > root.val) {
            root.right = insertIntoBST(root.right, node);
        } else {
            root.left = insertIntoBST(root.left, node);
        }

        return root;
    }

    private int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorderHelper(root, 0, k);
        return ans;
    }

    private int inorderHelper(TreeNode node, int prev, int k) {
        if (node == null || ans != -1) return 0; //also check if answer is already found

        // Total nodes processed before current node = prev + left Subtree Size
        int leftCnt = inorderHelper(node.left, prev, k);
        
        int curr = prev + leftCnt + 1;
        if (curr == k) {
            ans = node.val;
            return leftCnt + 1;
        }

        // Pass 'curr' as the number of nodes visited before exploring right subtree
        int rightCnt = inorderHelper(node.right, curr, k);

        // Return total size of this node's subtree
        return leftCnt + 1 + rightCnt;
    }
}