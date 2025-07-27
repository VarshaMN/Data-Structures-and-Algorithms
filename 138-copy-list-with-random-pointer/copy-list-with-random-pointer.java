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
        Node curr=head;
        Node prev=null;
        Node res=null;
        Map<Node,Node> map=new HashMap<>();

        while(curr!=null){
            Node newNode=new Node(curr.val);
            map.put(curr,newNode);
            if(prev==null) res=newNode;
            else prev.next=newNode;
            prev=newNode;
            curr=curr.next;


        }
        curr=head;
        Node temp=res;
        while(temp!=null){
            temp.random=map.get(curr.random);
            temp=temp.next;
            curr=curr.next;

        }
        return res;
    }
}