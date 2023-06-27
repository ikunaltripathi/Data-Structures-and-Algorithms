package linked_list;
    public class AddTwoNumbers {
        public static void main(String[] args) {
            int[] arr1 = {7, 2, 4, 3};
            int[] arr2 = {5, 6, 4};

            ListNode l1 = createLinkedList(arr1);
            ListNode l2 = createLinkedList(arr2);
            ListNode temp = addTwoNumbers(l1,l2);
            while (temp != null) {
                System.out.println(temp.val);
                temp = temp.next;
            }

            // do something with l1 and l2
        }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                if (l1.next != null && l2.next != null) return null;
                int s1 = size(l1);
                int s2 = size(l2);
                if (s2>s1) {
                    int temp = s1;
                    s1 = s2;
                    s2 = temp;
                    ListNode dd = l1;
                    l1 = l2;
                    l2 = dd;
                }
                return helper (l1, l2, s1-s2);
            }

            public static ListNode helper (ListNode n1, ListNode n2, int n) {
                if (n1.next == null && n2.next == null) {
                    ListNode temp = new ListNode(n1.val + n2.val);
                    return temp;
                }
                ListNode curr = new ListNode();
                int carry = 0;
                if (n>0) {
                    ListNode temp = helper (n1.next, n2, n-1);
                    curr.next = temp;
                    carry = curr.next.val /10;
                    curr.val = n1.val+carry;
                    curr.next.val = curr.next.val%10;
                }
                else {
                    ListNode temp = helper (n1.next,n2.next , n);
                    curr.next = temp;
                    carry = curr.next.val /10;
                    curr.val = n1.val+n2.val + carry;
                    curr.next.val = curr.next.val%10;
                }
                // if (curr.val/10 != 0) {
                //     ListNode temp = new ListNode(1);
                //     temp.next = curr;
                //     return temp;
                // }
                return curr.next;
            }

            public static int size(ListNode l1) {
                int s = 0;
                while (l1 != null) {
                    l1= l1.next;
                    s++;
                }
                return s;
            }

        public static ListNode createLinkedList(int[] arr) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            for (int val : arr) {
                curr.next = new ListNode(val);
                curr = curr.next;
            }

            return dummy.next;
        }
//        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            if (l1 == null || l2 == null) return l1;
//            int s1 = size(l1);
//            int s2 = size(l2);
//            if (s2>s1) {
//                int temp = s1;
//                s1 = s2;
//                s2 = temp;
//                ListNode dd = l1;
//                l1 = l2;
//                l2 = dd;
//            }
//            ListNode ans = new ListNode();
//            ListNode dummy = ans;
//            for (int i = 0; i<s1-s2; i++) {
//                ListNode temp = new ListNode(l1.val);
//                dummy.next = temp;
//                dummy = dummy.next;
//                l1 = l1.next;
//            }
//            while (l1 != null) {
//                ListNode temp = new ListNode(l1.val + l2.val);
//                dummy.next = temp;
//                dummy =dummy.next;
//                l1 = l1.next;
//                l2 = l2.next;
//            }
//            dummy = reverse(ans.next);
//            ListNode ddd = dummy;
//            int carry = 0;
//            while (dummy != null) {
//                if (carry > 0) dummy.val = dummy.val+carry;
//                carry = dummy.val/10;
//                dummy.val = dummy.val%10;
//                dummy = dummy.next;
//            }
//            return reverse (ddd);
//        }
//
//        public static ListNode reverse(ListNode head) {
//            if (head.next == null) return head;
//            ListNode temp = reverse (head.next);
//            head.next.next = head;
//            head.next = null;
//            return temp;
//        }
//
//        public static int size(ListNode l1) {
//            int s = 0;
//            while (l1 != null) {
//                l1 = l1.next;
//                s++;
//            }
//            return s;
//        }
}
