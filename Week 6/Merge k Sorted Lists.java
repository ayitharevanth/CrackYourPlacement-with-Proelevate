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
    public static ListNode mergeKLists(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }
    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val < l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
// class Solution {
//     ListNode merge2Lists(ListNode l1, ListNode l2) {
//         if(l1 == null)
//             return l2;
//         if(l2 == null)
//             return l1;
//         ListNode sentinel = new ListNode(-1), ptr = sentinel;
//         while(l1 != null && l2 != null) {
//             if(l1.val <= l2.val) {
//                 ptr.next = l1;
//                 l1 = l1.next;
//             } else {
//                 ptr.next = l2;
//                 l2 = l2.next;
//             }
//             ptr = ptr.next;
//         }
//         if(l1 != null)
//             ptr.next = l1;
//         else if(l2 != null)
//             ptr.next = l2;
//         return sentinel.next;
//     }

//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists == null || lists.length == 0)
//             return null;
//         int end = lists.length-1;

//         while(end != 0) {
//             int l = 0, r = end;
//             while(l < r) {
//                 lists[l] = merge2Lists(lists[l], lists[r]);
//                 l++;
//                 r--;
//             }
//             end = r;
//         }

//         return lists[0];
//     }
// }
 

 

        
    
