import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.tree.TreeNode;

public class isSymmetric {
    //try 1- passed but not efficient as original
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

    // try - 2 , 195 out of 200 cases passed

    public boolean isSymmetric2(TreeNode root) {
        return isPalindrome2(treeToList(root));
    }

    public ArrayList<Integer> treeToList(TreeNode node) {
        if (node == null)
            return new ArrayList<>(Arrays.asList((Integer) null));

        ArrayList<Integer> left = treeToList(node.left);

        left.add(node.val);

        left.addAll(treeToList(node.right));

        return left;
    }

    public boolean isPalindrome2(ArrayList<Integer> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            Integer left = list.get(i);
            Integer right = list.get(j);

            if (left == null && right == null) {
                // both null, fine
            } else if (left == null || right == null) {
                return false; // one is null, not symmetric
            } else if (!left.equals(right)) {
                return false; // values differ
            }
            i++;
            j--;
        }
        return true;
    }

}
