public class TestListNode {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = l1;

        int i = 1;
        for(;;){
            ListNode l3;
            if(i == 1){
                l3 = l1.next;
                i = 2;
            }else{
                l3 = l2.next;
                i = 1;
            }
            System.out.println(l3.val);
        }
    }
}
