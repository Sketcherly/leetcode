/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }


        int out = 0;
        ListNode root = new ListNode();

        ListNode ptr = root;

        // 先处理第一位
        int sum = l1.val + l2.val;
        out = sum / 10;
        root.val = sum % 10;

        while (l1.next != null || l2.next != null) {

            ListNode next = new ListNode();
            ptr.next = next;
            ptr = next;

            sum = out;

            if (l1.next != null && l2.next != null) {
                sum += l1.next.val + l2.next.val;

                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.next != null) {
                sum += l1.next.val;

                l1 = l1.next;
            } else {
                sum += l2.next.val;

                l2 = l2.next;
            }

            out = sum / 10;
            next.val = sum % 10;

        }

        if (out != 0) {
            ptr.next = new ListNode(out);
        }

//        ListNode idx = root;
//        System.out.println(idx.val);
//
//        while (idx.next != null) {
//            System.out.println(idx.next.val);
//            idx = idx.next;
//        }

        return root;

    }
}