class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            Node clone = new Node(curr.val);
            curr.next = clone;
            clone.next = nextNode; 
            curr = nextNode;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;

        while (curr != null) {
            Node nextNode = curr.next.next;
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;
            curr.next = nextNode;
            
            curr = nextNode;
        }
        
        return dummyHead.next;
    }
}