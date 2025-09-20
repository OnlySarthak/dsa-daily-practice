/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class deletEle {
    //by me
    public void deleteNode(ListNode node) {
        //search element
        while(node.next.next!=null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
    

    //trick
    public void deleteNode(ListNode node) {
        node.val = node.next.val;  
        node.next = node.next.next;
    }

}
