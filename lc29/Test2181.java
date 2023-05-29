public class Test2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode p = head;

        // ListNode z = p.next;
        ListNode z = p;
        while ((p = p.next) != null) {
            if (p.val == 0) {
                // z = p;
                // z = z.next;
                if (p.next == null) {
                    z.next = null;
                    break;
                }
                z = z.next;
                z.val = 0;
            } else {
                z.val += p.val;
            }
        }
        // z.next = null;

        return head;
    }
}
