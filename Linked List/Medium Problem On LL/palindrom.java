public class palindrom {
    public ListNode compareRec(ListNode back, ListNode front, int len, int idx) {   //initialy (head, head, length, 1)
        //by me
        if (back == null) {
            return front;
        }

        ListNode nextFront = compareRec(back.next, front, len, idx + 1);

        if (nextFront == null) return null;

        if (idx < len / 2) {
            return nextFront;
        } else {
            if (back.val == nextFront.val) {
                return nextFront.next;
            } else {
                return null;
            }
        }
    }

    boolean f(ListNode node, Queue<Integer> qu) {   //initialy(head, empty queue)
    if (node == null) return true;  

    qu.add(node.val);

    if (!f(node.next, qu)) return false;

    Integer frontVal = qu.poll();
    if (frontVal == null || node.val != frontVal) return false;

    return true;
}
}
