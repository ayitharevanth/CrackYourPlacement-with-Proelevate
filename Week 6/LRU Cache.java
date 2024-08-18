class Node{
    int key, val;
    Node prev, next;
    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null; 
        this.next = null;
    }
}

class LRUCache {
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> mpp = new HashMap<>();
    int cap, size = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = mpp.get(key);
        if( node == null ) return -1;

        int val = node.val;
        deleteNode(node);
        addNode(node);
        return val;
    }
    
    public void put(int key, int value) {
        if (mpp.get(key) != null) {
            deleteNode(mpp.get(key));
            addNode(new Node(key, value));
            mpp.put(key, head.next);
            return;
        }

        if (size == cap) {
            mpp.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        mpp.put(key,  head.next);
    }

    private void addNode(Node newNode){
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }
    
    private void deleteNode(Node delNode){
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
        size--;
    }
}
