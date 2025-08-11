



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
     private static void printList(Node head){
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            cnt++;
        }
        System.out.println("\nlength of LL : " + cnt);
     }

     private static Node removerK(Node head, int k){
        if(head==null)return head;
        if(k==1){ head = head.next;
        return head;}

        Node iterNode = head, prev = null;
        int cnt = 0;
        
        while(iterNode!= null){
            cnt++;
            if(cnt == k){
                prev.next = prev.next.next;
                return head;
            }
            prev = iterNode;
            iterNode = iterNode.next;
        }
        return head;
     }
    public static void main(String[] args) {
        int[] arr = {12,13,14};         // Sample array
        Node head = convertArr2LL(arr);   // Convert array to linked list

        printList(head);
        head = removerK(head, 1);        
        printList(head);
    }

    private static Node deleteHead(Node head){
        if(head==null)return head;
        head = head.next;
        return head;
    }
    
    private static Node deleteTail(Node head){
        if(head==null || head.next == null){
            return null;
        }
        Node iterNode = head;
        while (iterNode.next.next != null) {
            iterNode = iterNode.next;
        }
        iterNode.next=null;
        return head;
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
