class smallestKth {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderHelper(root, result);  // fixed: was 'node'
        
        // k-th smallest in sorted inorder list
        return result.get(k - 1);     // 0-based index
    }

    private void inorderHelper(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;

        inorderHelper(node.left, result);   // visit left subtree
        result.add(node.val);               // add current node
        inorderHelper(node.right, result);  // visit right subtree
    }
}
