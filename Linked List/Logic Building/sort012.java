// package Linked List.Logic Building;
/*
Definition of singly linked list:
class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
*/

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Find tail and count 0s and 2s
        int count0 = 0;
        int count2 = 0;
        ListNode tail = head;

        if (tail.data == 0) count0++;
        if (tail.data == 2) count2++;

        while (tail.next != null) {
            tail = tail.next;
            if (tail.data == 0) count0++;
            if (tail.data == 2) count2++;
        }

        // Dummy head simplifies prepending 0s to the front
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        // Step 2: Move 0s to front, 2s to back until all counts are handled
        while (curr != null && (count0 > 0 || count2 > 0)) {
            if (curr.data == 0 && curr != dummy.next) { 
                // Detach curr
                prev.next = curr.next;
                // Prepend to head
                curr.next = dummy.next;
                dummy.next = curr;
                // Move curr forward
                curr = prev.next;
                count0--;
            } else if (curr.data == 0) {
                // Already at head, just skip
                prev = curr;
                curr = curr.next;
                count0--;
            } else if (curr.data == 2) {
                // Detach curr
                prev.next = curr.next;
                // Append to tail
                tail.next = curr;
                tail = curr;
                tail.next = null; // Prevent infinite cycle
                // Move curr forward
                curr = prev.next;
                count2--;
            } else {
                // It's a 1, just keep moving
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}

public class sort012 {
    
}
