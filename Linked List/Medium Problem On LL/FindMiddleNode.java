public class FindMiddleNode {
    public ListNode middleNode(ListNode head) {     //mine soln
        if(head == null || head.next == null)return head;
        
        ListNode iterNode = head;
        int ctr = 1;
        
        while(iterNode != null){
            if(ctr%2 == 0){
                head = head.next;
            }
            ctr++;
            iterNode = iterNode.next;
        }
        
        return head;
    }

    static Node findMiddle(Node head) {     //standard soln
        // Initialize the slow pointer to the head.
        Node slow = head; 
        
        // Initialize the fast pointer to the head.
        Node fast = head;   

        // Traverse the linked list using
        // the Tortoise and Hare algorithm.
        while (fast != null && fast.next != null && slow != null) {
            // Move fast two steps.
            fast = fast.next.next;  
            // Move slow one step.
            slow = slow.next;        
        }
        // Return the slow pointer,
        // which is now at the middle node.
        return slow;  
    }

}
