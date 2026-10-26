import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] toArray(Node head) {
        List<Integer> list = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}