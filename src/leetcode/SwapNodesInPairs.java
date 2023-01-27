package leetcode;

public class SwapNodesInPairs {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;

        int temp;
        ListNode currNode = head;

        while(currNode!=null && currNode.next!=null){
            temp = currNode.val;
            currNode.val = currNode.next.val;
            currNode.next.val = temp;

            currNode = currNode.next.next;
        }

        return head;
    }

    void display(ListNode head){
        ListNode currentNode = head;

        while(currentNode != null){
            System.out.print(currentNode.val+" ");
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next = new ListNode(3);
        head.next = new ListNode(4);

        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        swapNodesInPairs.swapPairs(head);
        swapNodesInPairs.display(head);
    }
}
