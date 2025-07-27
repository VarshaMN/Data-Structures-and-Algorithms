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
        if (head == null) return null;

        // Step 1: Interweave cloned nodes with the original list
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Set random pointers for the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original and cloned lists
        Node original = head, clone = head.next, cloneHead = head.next;
        while (original != null) {
            original.next = clone.next;
            original = original.next;
            if (clone.next != null) {
                clone.next = clone.next.next;
            }
            clone = clone.next;
        }

        return cloneHead;
    }
}