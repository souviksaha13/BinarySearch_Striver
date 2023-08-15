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
    public ListNode partition(ListNode head, int x) {
        List<Integer> lo = new ArrayList<>();
        List<Integer> hi = new ArrayList<>();

        ListNode curr = head;
        while(curr != null) {
            if(curr.val < x) lo.add(curr.val);
            else hi.add(curr.val);
            curr = curr.next;
        }
        curr = head;
        
        for(int i=0; i<lo.size(); i++) {
            curr.val = lo.get(i);
            curr = curr.next;
        }
        for(int i=0; i<hi.size(); i++) {
            curr.val = hi.get(i);
            curr = curr.next;
        }
        return head;
    }
}