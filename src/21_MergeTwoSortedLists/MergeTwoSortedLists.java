public class MergeTwoSortedLists {



    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode NewList = new ListNode();
            ListNode NewListHead = NewList;
            if (l1 == null){
                return l2;
            }
            if (l2 == null){
                return l1;
            }
            while (l1 != null || l2 != null){
                if (l1 != null && l2 != null){
                    if (l1.val <= l2.val){
                        NewList.val = l1.val;
                        l1 =l1.next;
                    }
                    else{
                        NewList.val = l2.val;
                        l2 =l2.next;
                    }
                }
                else if (l1 == null && l2 != null){
                    NewList.val = l2.val;
                    l2 =l2.next;
                }
                else{
                    NewList.val = l1.val;
                    l1 =l1.next;
                }
                if (l1 != null || l2 != null){
                    NewList.next = new ListNode();
                    NewList = NewList.next;
                }
            }
            return NewListHead;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
