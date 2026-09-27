package Linked List.Logic Building;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Edge case: 0, 1, or 2 nodes don't need reordering
        if (head == null || head.next == null) return head;

        ListNode i = head;          // Odd pointer
        ListNode j = head.next;     // Even pointer
        ListNode og_headj = j;      // Store original head of even list

        // Loop safely while even pointer and its next node exist
        while (j != null && j.next != null) {
            i.next = j.next;        // Link current odd to next odd
            i = i.next;             // Move odd pointer forward

            j.next = i.next;        // Link current even to next even
            j = j.next;             // Move even pointer forward
        }

        i.next = og_headj;          // Connect end of odd chain to start of even chain
        return head;
    }
}

public class segregateOddEven {
    
}
