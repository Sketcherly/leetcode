public class Main {
    public static void main(String[] args) {


        ListNode l1 = build(new int[]{2,4,9});
        ListNode l2 = build(new int[]{5,6,4,9});

        ListNode ans = new Solution().addTwoNumbers(l1, l2);

        while (ans != null) {
            System.out.print(ans.val);
            System.out.print(" ");

            ans = ans.next;
        }

    }

    public static ListNode build(int[] numArr) {

        ListNode root = new ListNode(numArr[0]);
        ListNode ptr = root;

        for (int i = 1; i < numArr.length; i++) {
            ListNode next = new ListNode(numArr[i]);
            ptr.next = next;
            ptr = next;
        }

        return root;

    }

}