import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(int data, Node right) {
        this.data = data;
        this.left = null;
        this.right = right;
    }

    public Node(Node left, int data) {
        this.data = data;
        this.left = left;
        this.right = null;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(11);
        boolean letTest = false;

        root.left = new Node(13);
        root.right = new Node(14);
        root.left.left = new Node(15);

        root.right.right = new Node(15);
        root.right.right.right = new Node(15);
        
        System.out.println("height: "+hight(root, 1));

        if (letTest) {
            System.out.println("preorder :");
            preorderTransverse(root);
            System.out.println("\n inorder :");
            inorderTransverse(root);
            System.out.println("\n postorder :");
            postorderTransverse(root);
            System.out.println("level vise travelsal");
            levelOrderTraversel(root);
        }

    }

    

    private static void postorderItertive(Node root) {
        if (root == null)
            return;

        Stack<Node> st = new Stack<>();
        Stack<Node> printingOrderStack = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();

            printingOrderStack.push(curr);

            if (curr.left != null)
                st.push(curr.left);
            if (curr.right != null)
                st.push(curr.right);
        }

        // Final printing (reverse order)
        while (!printingOrderStack.isEmpty()) {
            System.out.println(printingOrderStack.pop().data);
        }
    }

    private static void levelOrderTraversel(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println(currentNode.data);

            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);

        }
    }

    private static void preorderIterative(Node root) {
        if (root == null)
            return; // edge case

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();
            System.out.println(curr.data);

            // Push right child first so that left is processed first
        }
    }

    private static void inorderIterative(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (curr != null || !st.isEmpty()) {
            // Go all the way left
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            // Now process node
            curr = st.pop();
            System.out.println(curr.data);

            // Go right subtree
            curr = curr.right;
        }
    }

    private static void inorderTransverse(Node node) {
        if (node == null)
            return;

        preorderTransverse(node.left);

        System.out.print(node.data + " ");

        preorderTransverse(node.right);
    }

    private static void postorderTransverse(Node node) {
        if (node == null)
            return;

        preorderTransverse(node.left);
        preorderTransverse(node.right);

        System.out.print(node.data + " ");
    }

    private static void preorderTransverse(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");

        preorderTransverse(node.left);
        preorderTransverse(node.right);
    }
}
