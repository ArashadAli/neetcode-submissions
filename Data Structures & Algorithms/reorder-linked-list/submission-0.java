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
    public void reorderList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int remInd = 1;

        temp = head;
        int len = list.size();
        for(int i = 0; i < list.size(); i++) {

            if(i == 0) {
                temp.val = list.get(i);
                temp = temp.next;
            }
            else if(i % 2 == 0) {
                temp.val = list.get(remInd-1);
                temp = temp.next;
            }
            else{
                temp.val = list.get(len - remInd);
                remInd++;
                temp = temp.next;
            }
        }
    }
}
