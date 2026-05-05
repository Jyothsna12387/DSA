/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        //edge case
        if(head == null || head.next == null){
            return head;
        }
        //find the length of list and find tail(last node) and make it circular
        ListNode temp = head;
        int n = 1;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }
        temp.next = head;

        k = k % n;
        int steps = n-k;
        ListNode curr = head;
        for(int i=1; i<steps; i++){
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;

        return newHead;
    }
}