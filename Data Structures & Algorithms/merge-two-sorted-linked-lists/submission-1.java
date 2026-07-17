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
    public ListNode mergeTwoLists(ListNode l1, ListNode list2) {
        List<Integer> list1 = new ArrayList<>();

        ListNode temp = l1;
        while(temp != null) {
            list1.add(temp.val);
            temp = temp.next;
        }

        temp = list2;
        while(temp != null) {
            list1.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(list1);
        if(list1.size() == 0) return null;
        ListNode newHead = new ListNode(list1.get(0), null);
        temp = newHead;
        for(int i = 1; i < list1.size(); i++) {
            temp.next = new ListNode(list1.get(i), null);
            temp = temp.next;
        }

        return newHead;
    }
}