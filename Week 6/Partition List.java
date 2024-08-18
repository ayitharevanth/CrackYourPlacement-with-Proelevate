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
        if(head==null) return null;
        
      
        ListNode left=new ListNode(0);
        ListNode right=new ListNode(0);
        
        ListNode tail1=left , tail2=right;
      
        ListNode iterator=head;
        while(iterator!=null){
            if(iterator.val<x){
                tail1.next=iterator;
                tail1=tail1.next;
            }else{
                tail2.next=iterator;
                tail2=tail2.next;
            }
           iterator=iterator.next;
        }
        tail1.next=right.next;
        tail2.next=null; // important

        return left.next;
    }
}
