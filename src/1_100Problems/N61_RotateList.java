import java.util.ArrayList;
import java.util.List;

public class N61_RotateList {

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {

            if(k == 0 || head == null || head.next == null) return head;
            List<ListNode> listNodeList = new ArrayList<>();
            ListNode listNode = head;
            listNodeList.add(listNode);
            while(true){
                if(listNode.next != null){
                    listNode = listNode.next;
                    listNodeList.add(listNode);
                }else break;
            }
            k = k % listNodeList.size();
            if(k == 0) return head;

            ListNode lastListNode = listNodeList.get(listNodeList.size() - 1);
            lastListNode.next = listNodeList.get(0);
            ListNode stopNode = listNodeList.get((listNodeList.size() - 1 - k));
            stopNode.next = null;
            return listNodeList.get(listNodeList.size() - k);

        }
    }
}
