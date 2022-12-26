class Add2LL {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode() { super(); }
        public ListNode(int val) { this.val = val; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode sum = new ListNode(-1);
        ListNode currDigit = sum;

        ListNode c1 = l1;
        ListNode c2 = l2;

        boolean carryOne = false;
        while (c1 != null || c2 != null || carryOne) {
            int s = 0;
            if (c1 != null && c2 != null)
                s = c1.val + c2.val;
            else if (c1 == null && c2 != null)
                s = c2.val;
            else if (c1 != null && c2 == null)
                s = c1.val;
            
            if (carryOne) s++;
            if (s > 9) {
                currDigit.next = new ListNode(s % 10);
                carryOne = true;
            } else {
                currDigit.next = new ListNode(s);
                carryOne = false;
            }

            c1 = c1 == null ? null : c1.next;
            c2 = c2 == null ? null : c2.next;
            currDigit = currDigit.next;
        }
        return sum.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode sum = addTwoNumbers(l1, l2); // should return 7->0->8 (since 342+465=807)
        while (sum != null) {
            System.out.print(sum.val + "->");
            sum = sum.next;
        }
    }
}