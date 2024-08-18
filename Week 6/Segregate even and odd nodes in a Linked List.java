import java.util.*;

class Node{
    int data;
    Node next;
    
    public Node(int x){
        data = x;
        next = null;
    }
}

class LinkList{
    Node head;
    
    void p(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    Node divide(Node head){
        Queue<Node> qe = new LinkedList<Node>();
        Queue<Node> qo = new LinkedList<Node>();
        Queue<Node> q = new LinkedList<Node>();
        
        Node cur = head;
        while (cur != null){
            if(cur.data % 2 == 0)
                qe.add(cur);
            else
                qo.add(cur);
            cur = cur.next;
        }
        Node node = new Node(-100);
        Node ans = node;
        
        while(!qe.isEmpty()){
            q.add(qe.poll());
        }
        
        while(!qo.isEmpty()){
            q.add(qo.poll());
        }
        
        while(!q.isEmpty()){
            node.next = q.poll();
            node = node.next;
        }
        
        node.next = null;
        return ans.next;
    }
    
    public static void main(String args[]){
        LinkList llist = new LinkList();
        llist.head = new Node(9);
        llist.head.next = new Node(1);
        llist.head.next.next = new Node(6);
        llist.head.next.next.next = new Node(7);
        llist.head.next.next.next.next = new Node(3);
        llist.head.next.next.next.next.next = new Node(4);
        
        Node temp = llist.divide(llist.head);
        llist.p(temp);
    }
}
