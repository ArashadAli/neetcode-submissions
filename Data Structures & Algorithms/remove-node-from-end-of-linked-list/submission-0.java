class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: Create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // Step 2: Move fast (n + 1) steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 3: Move both pointers together
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 4: Remove the nth node
        slow.next = slow.next.next;

        return dummy.next;
    }
}