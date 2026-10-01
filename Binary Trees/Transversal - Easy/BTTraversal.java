class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return inorderTrGeneratore(root, ans);
    }

    private List<Integer> inorderTrGeneratore(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;

        inorderTrGeneratore(root.left, ans);
        ans.add(root.val);
        inorderTrGeneratore(root.right, ans);

        return ans;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return preorderTrGeneratore(root, ans);
    }

    private List<Integer> preorderTrGeneratore(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;

        ans.add(root.val);
        preorderTrGeneratore(root.left, ans);
        preorderTrGeneratore(root.right, ans);

        return ans;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return postorderTrGeneratore(root, ans);
    }

    private List<Integer> postorderTrGeneratore(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;

        postorderTrGeneratore(root.left, ans);
        postorderTrGeneratore(root.right, ans);
        ans.add(root.val);

        return ans;
    }
}