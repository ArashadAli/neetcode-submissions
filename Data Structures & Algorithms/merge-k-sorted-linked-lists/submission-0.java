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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;

        List<Integer> arr = new ArrayList<>();

        for (ListNode head : lists) {
            while (head != null) {
                arr.add(head.val);
                head = head.next;
            }
        }

        Collections.sort(arr);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for (int val : arr) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        return dummy.next;
    }
}
