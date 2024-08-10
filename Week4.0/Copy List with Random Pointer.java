class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        
        Node curr = head;
        //add a copy extra node after each node
        while (curr != null)
        {
            Node temp = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = temp;
            curr = temp;            
        }
        
        // put the random reference for copies
        curr = head;
        while (curr != null)
        {
            if(curr.next != null)  
              curr.next.random = (curr.random != null) ? curr.random.next : curr.random;  
  
        // move to the next newly added node by  
        // skipping an original node  
        curr = (curr.next != null) ? curr.next.next : curr.next;  
        }
        
        // separa in two lists : original and copy
        // restore initial next configuration
        Node original = head, copy = head.next;  
  
        // save the start of copied linked list  
        Node result = copy;  

        // now separate the original list and copied list  
        while (original != null && copy != null)  
        {  
            original.next = (original.next != null) ? original.next.next : original.next;  
            copy.next = (copy.next != null) ? copy.next.next : copy.next;  
            
            original = original.next;  
            copy = copy.next;  
        }  
        return result;  
    }
}
