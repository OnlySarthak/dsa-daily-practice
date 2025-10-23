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
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        //main engine 
        map = rightView(root, 0 , map);

        result.addAll(map.values());

        return result;
    }

    public static Map<Integer, Integer> rightView(Tree node,int curr_horz_level, Map map) {
        if (node == null) return map;
        
        map.put(curr_horz_level, node.val);

        
        // if(!map.containsKey(curr_horz_level+1))rightView(map.left, curr_horz_level+1, map);
        map = rightView(node.left, curr_horz_level+1, map);
        
        map = rightView(node.right, curr_horz_level+1, map);

        return map;
    }
}