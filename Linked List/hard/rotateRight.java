class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int length = 1; // start at 1 since we count while moving to the tail
        ListNode tail = head;

        // loop tail till tail.next == null and count length
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // calculate net rotations needed
        k = k % length;
        if (k == 0) return head;

        // loop i till (length - k - 1) to find the node right before the split
        ListNode i = head;
        for (int step = 0; step < length - k - 1; step++) {
            i = i.next;
        }

        ListNode newhead = i.next;
        i.next = null;
        tail.next = head;

        return newhead;
    }
}