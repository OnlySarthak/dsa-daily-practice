import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.get(0);
                q.remove(0); // inefficient but works

                if (curr != null) {
                    level.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                } else {
                    level.add(null);
                }
            }

            if (!isPalindrome(level))
                return false;
        }

        return true;
    }

    private boolean isPalindrome(ArrayList<Integer> arr) {
        int i = 0, j = arr.size() - 1;
        while (i < j) {
            if (arr.get(i) == null && arr.get(j) == null) {
                i++;
                j--;
            } else if (arr.get(i) == null || arr.get(j) == null) {
                return false;
            } else if (!arr.get(i).equals(arr.get(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

}
