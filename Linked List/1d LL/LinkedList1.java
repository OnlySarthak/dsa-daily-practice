class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList1 {

    private static Node convertArr2LL(int[] arr) {
        Node head = new Node(arr[0]);  // First node
        Node mover = head;             // To keep track of the last node

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);  // Create new node
            mover.next = temp;             // Link last node to new node
            mover = temp;                  // Move to new last node
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};         // Sample array
        Node head = convertArr2LL(arr);   // Convert array to linked list
        int cnt = 0;

        // Print the linked list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            cnt++;
        }

        System.out.println("length of LL : " + cnt);
    }

     private static boolean search(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;  // Found!
            }
            temp = temp.next;
        }
        return false; // Not found
    }
}
