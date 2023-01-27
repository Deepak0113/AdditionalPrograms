package leetcode;

public class RemoveDuplicatesFromSortedListII {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode currNode = head, prevNode = null;
        boolean isDuplicate = false;

        while(currNode.next!=null){
            if(currNode.val == currNode.next.val){
                currNode.next = currNode.next.next;
                isDuplicate = true;
            } else{
                if(isDuplicate){
                    if(prevNode==null){
                        head = currNode.next;
                    } else{
                        prevNode.next = currNode.next;
                    }

                    isDuplicate = false;
                } else{
                    prevNode = currNode;
                }

                currNode = currNode.next;
            }
        }

        if(isDuplicate && prevNode!=null) prevNode.next=null;
        else if(isDuplicate) return null;

        return head;
    }

    public static void main(String[] args) {

    }
}
