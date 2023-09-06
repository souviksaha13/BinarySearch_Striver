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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int n = 0;
        ListNode curr = head;
        while(curr != null) {
            n++;
            curr = curr.next;
        }

        int num = n/k, quo = n%k, cnt = 0;
        curr = head;
        if(num == 0) {
            for(int i = 0; i<k; i++) {
                if(curr != null) {
                    ans[i] = curr;
                    curr = curr.next;
                    ans[i].next = null;
                }
                
            }
        }
        else {
            for(int i=0; i<k; i++) {
                ans[i] = curr;
                cnt = 1;
                if(quo != 0) {
                    cnt--;
                    quo--;
                }
                while(cnt != num && curr.next != null) {
                    curr = curr.next;
                    cnt++;
                }
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp;
            }
        }

        return ans;
    }
}