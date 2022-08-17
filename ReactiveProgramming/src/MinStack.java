public class MinStack {

    private ListNode head = null;
    public MinStack() {

    }

    public void push(int val) {
        if (head == null){
            new ListNode(val);
        } else  {
            ListNode tmp = new ListNode(val);
            tmp.next = head;
            head = tmp;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        ListNode tmp = head;
        int min = head.val;
        while (tmp != null){
            if (tmp.val < min){
                min = tmp.val;
            }
            tmp = tmp.next;
        }
        return min;
    }
}
