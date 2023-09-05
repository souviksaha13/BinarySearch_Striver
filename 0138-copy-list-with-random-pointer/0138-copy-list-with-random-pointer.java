/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;

        while(temp != null) {
            Node nex = temp.next;
            Node neew = new Node(temp.val);
            temp.next = neew;
            neew.next = nex;
            temp = nex;
        }
        temp = head;
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        Node cloneHead = new Node(0);
        Node tempHead = cloneHead;
        temp = head;
        while(temp != null) {
            Node next = temp.next.next;
            Node clone = temp.next;
            tempHead.next = clone;
            tempHead = clone;
            temp.next = next;
            temp = next;
        }
        return cloneHead.next;
    }
}