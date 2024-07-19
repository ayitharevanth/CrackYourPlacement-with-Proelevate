# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        
        if not head:
            return head

        head.next = self.removeElements(head.next, val)        
        if head.val == val:
            head = head.next

        return head      
