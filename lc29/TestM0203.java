public class TestM0203 {
    public void deleteNode(ListNode node) {
        // 将下个结点的值拿过来
        node.val = node.next.val;
        // 删除下个结点
        node.next = node.next.next;
    }
}
