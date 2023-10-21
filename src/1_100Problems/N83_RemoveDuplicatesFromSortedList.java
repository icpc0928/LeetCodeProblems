public class N83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args){

    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode current = head;
            while(current != null && current.next != null){
                if(current.next.val == current.val){
                    current.next = current.next.next;
                }else{
                    current = current.next;
                }
            }

            return head;
        }
    }

    //已經定義的
//    public static class ListNode{
//        int val;
//        ListNode next;
//        //建構式
//        ListNode(){}
//        ListNode(int val){
//            this.val = val;
//        }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
}
