class Node{
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public Node(int data, Node right){
        this.data = data;
        this.left = null;
        this.right = right;
    }
    public Node(Node left, int data){
        this.data = data;
        this.left = left;
        this.right = null;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(11);
        
        root.left = new Node(13);
        root.right = new Node(14);

        root.left.left = new Node(15);

        System.out.println("preorder :");
        preorderTransverse(root);
        System.out.println("\n inorder :");
        inorderTransverse(root);
        System.out.println("\n postorder :");
        postorderTransverse(root);
    }

    private static void inorderTransverse(Node node){
        if(node==null)return;

        preorderTransverse(node.left);

        System.out.print(node.data + " ");

        preorderTransverse(node.right);
    }
    private static void postorderTransverse(Node node){
        if(node==null)return;
        
        preorderTransverse(node.left);
        preorderTransverse(node.right);

        System.out.print(node.data + " ");
    }
    private static void preorderTransverse(Node node){
        if(node==null)return;

        System.out.print(node.data + " ");

        preorderTransverse(node.left);
        preorderTransverse(node.right);
    }
}
