/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode kthNode = findKthNode(curr, k);
            if(kthNode == null) {
                if(prev != null) prev.next = curr;
                    break;
            }
            ListNode nxt = kthNode.next;
            kthNode.next = null;
            reverse(curr);
            if(curr == head) {
                head = kthNode;
            }
            else{
                prev.next = kthNode;
            }
            prev = curr;
            curr = nxt;
        }
        return head;
    }

    public ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;

        while(curr != null) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }

    public ListNode findKthNode(ListNode curr, int k) {
        k -= 1;
        while(curr != null && k > 0) {
            curr = curr.next;
            k -= 1;
        }
        return curr;
    }
}
