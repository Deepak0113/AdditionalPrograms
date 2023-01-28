package leetcode;

import leetcode.additionals.ListNode;

public class RemoveNthNodeFromEndOfList {
    private ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;

        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            if(n!=0){
                curr = curr.next;
                n--;
            } else{
                prev = prev==null ? head : prev.next;
                curr = curr.next;
            }
        }

        if(prev==null){
            return head.next;
        }
        prev.next = prev.next.next;

        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList remove = new RemoveNthNodeFromEndOfList();
        int[] arr = {1,2,3,4,5};
        int n=2;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for(int i=1; i<arr.length; i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        System.out.print(remove.removeNthFromEnd(head, n));
    }
}
