// package Linked List.Logic Building;

//from me
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = new ListNode(-1, head);
        engine(tempHead, n);
        return tempHead.next;
    }

    public int engine(ListNode node, int n) {
        if (node == null) return 0;

        // Unwind from end: count distance from the end of the list
        int distFromEnd = engine(node.next, n) + 1;

        // When we are at the node right BEFORE the target
        if (distFromEnd == n + 1) {
            node.next = node.next.next; // Delete the target node
        }

        return distFromEnd;
    }
}

//standard solution
class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 1. Advance fast pointer so it is n + 1 steps ahead of slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 2. Move both until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 3. slow is now right before the Nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }
}



public class removeNthNodeFromEnd {
    
}
