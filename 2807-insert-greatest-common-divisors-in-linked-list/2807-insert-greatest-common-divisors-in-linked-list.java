class Solution {
public ListNode insertGreatestCommonDivisors(ListNode head) {
ListNode curr = head;

    while (curr != null && curr.next != null) {
        int a = curr.val, b = curr.next.val;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        ListNode node = new ListNode(a);
        node.next = curr.next;
        curr.next = node;
        curr = node.next;
    }
    return head;
}

}