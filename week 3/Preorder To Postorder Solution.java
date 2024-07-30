static class Solution {
    public Node Bst(int pre[], int size) {
        Stack<Node> s = new Stack<>();
        Node root = new Node(pre[0]);
        s.add(root);
        for (int i = 1; i < size; i++) {
            Node temp = null;
            while (!s.isEmpty() && pre[i] > s.peek().data) {
                temp = s.pop();
            }
            if (temp == null) {
                s.peek().left = new Node(pre[i]);
                s.add(s.peek().left);
            } else {
                temp.right = new Node(pre[i]);
                s.add(temp.right);
            }
        }
        return root;
    }
}
