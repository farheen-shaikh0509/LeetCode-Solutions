
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
     PriorityQueue<ListNode> minHeap = 
     new PriorityQueue<> ((a, b) -> Integer.compare(a.val, b.val));

     //add head for all nodes
     for(ListNode node : lists){
        if(node != null){
minHeap.offer(node);

        }

     } 

ListNode dummy = new ListNode(0);

ListNode current = dummy;
while(!minHeap.isEmpty()){
    ListNode node = minHeap.poll();
    current.next = node;

    current = current.next;

    if(node.next != null){
        minHeap.offer(node.next);

    }

}
return dummy.next;    
    }
}

// Time = O(Nlogk)
//space = O(k), for min heap