package linked_list;

public class KNodes {
    public static void main(String[] args) {
        ListNode n = new ListNode(5, null);
        ListNode m = new ListNode(4, n);
        ListNode l = new ListNode(3, m);
        ListNode k = new ListNode(2, l);
        ListNode j = new ListNode(1, k);
        ListNode temp = reverseKGroup(j, 2);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
        public static ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1) return head;
            ListNode size = head;
            int count = 1;
            while (size != null) {
                count++;
                size = size.next;
            }
            ListNode prev = null;
            ListNode pres = head;
            ListNode next = pres.next;
            ListNode last = prev;
            ListNode temp = head;
            for (int i = 0; i < count / k; i++) {
                for (int j = 0; j < k; j++) {
                    pres.next = prev;
                    prev = pres;
                    pres = next;
                    if (next != null) next = next.next;
                }
                if (last == null) head = prev;
                else last.next = prev;
                temp.next = pres;
                last = temp;
                temp = temp.next;
                prev = null;
                pres = temp;
                if (pres != null) next = pres.next;
            }
            return head;
        }
}
