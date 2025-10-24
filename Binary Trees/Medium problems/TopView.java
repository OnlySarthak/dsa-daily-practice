import java.util.*;

import javax.swing.tree.TreeNode;

class Tree {
    int val;
    Tree left, right;
    Tree(int val) { this.val = val; }
}

public class TopView {
    static class Pair {
        Tree node;
        int hd;
        Pair(Tree node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static ArrayList<Integer> topView(Tree root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Map to store first node at each horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS: stores node + its horizontal distance
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Tree node = temp.node;
            int hd = temp.hd;

            // store only first node at each horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        result.addAll(map.values());
        return result;
    }

    public static ArrayList<Integer> bottomView(Tree root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Map to store last node at each horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Tree node = temp.node;
            int hd = temp.hd;

            // overwrite previous node at same HD
            map.put(hd, node.val);

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        result.addAll(map.values());
        return result;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, 0, result);
        return result;
    }

    private void rightView(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;

        // if this level already exists, replace
        if (level < result.size()) {
            result.set(level, node.val);
        } else {
            // if not, add new element
            result.add(node.val);
        }

        // traverse left and right (left first, right later) if you want the rightmost node at each level
        rightView(node.left, level + 1, result);
        rightView(node.right, level + 1, result);
    }

    public boolean isSymmetric(TreeNode root) {
        ArrayList<> q = new LinkedList<>();
        int levelChildCnt = 1;
        q.add(root);

        while(!q.isEmpty()){
            if(!isPalindrom(q))return false;

            for(int i = 0; i < Arr.size(); i++){
                TreeNode curr = q.get(0);

                if(curr != null )q.push(curr.left);
                if(curr != null )q.push(curr.right);
            }
        }

        return true;
    }
}