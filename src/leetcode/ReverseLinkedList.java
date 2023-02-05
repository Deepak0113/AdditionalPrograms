package leetcode;

public class ReverseLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;

        ListNode curr=head, temp1=null, temp2;

        while(curr!=null){
            temp2 = curr.next;
            curr.next = temp1;
            temp1 = curr;
            curr = temp2;
        }

        return temp1;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        int[] arr = new int[]{1,2,3,4,5};
    }
}
