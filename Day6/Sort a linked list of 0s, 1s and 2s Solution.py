class LinkedList(object):
	def __init__(self):

		# head of list
		self.head = None

	# Linked list Node
	class Node(object):
		def __init__(self, d):
			self.data = d
			self.next = None

	def sortList(self):

		# initialise count of 0 1 and 2 as 0
		count = [0, 0, 0]

		ptr = self.head

		while ptr != None:
			count[ptr.data]+=1
			ptr = ptr.next

		i = 0
		ptr = self.head

		while ptr != None:
			if count[i] == 0:
				i+=1
			else:
				ptr.data = i
				count[i]-=1
				ptr = ptr.next


	def push(self, new_data):
		new_node = self.Node(new_data)
		new_node.next = self.head

		self.head = new_node
