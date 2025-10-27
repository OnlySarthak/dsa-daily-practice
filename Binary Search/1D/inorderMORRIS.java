import java.util.Stack;

import javax.swing.tree.TreeNode;

public class inorderMORRIS {
    void inorderMorris3(TreeNode root) { // 3
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                // find the rightmost node of left subtree
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // make a temporary link
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // revert the link and visit node
                    pred.right = null;
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
    }

    void inorderIterative2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) { // go as far left as possible
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop(); // now visit node
            System.out.print(curr.val + " ");
            curr = curr.right; // explore right subtree
        }
    }

    void inorder1(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

}
