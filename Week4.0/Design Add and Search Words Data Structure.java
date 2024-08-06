class WordDictionary {

     private static class Node {
		private char data;
		private boolean isEnd;
		private Node[] children;

		public Node(char data) {
			this.data = data;
			this.isEnd = false;
			this.children = new Node[26];
		}
	}

	private Node root;

	private void insert(String word) {
		Node curr = this.root;
		for (int i = 0; i < word.length(); i++) {
			int childIdx = word.charAt(i) - 'a';
			if (curr.children[childIdx] == null) {
				curr.children[childIdx] = new Node(word.charAt(i));
			}
			curr = curr.children[childIdx];
		}
		curr.isEnd = true;
	}

	private boolean dfs(int index, Node curr, String word) {
		for(int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch == '.') {
               for(Node child : curr.children) {
                   if(child != null && dfs(i + 1, child, word)){
                       return true;
                   } 
               }
               return false;
            } else {
                 int childIdx = word.charAt(i) - 'a';
                 if(curr.children[childIdx] == null){
                     return false;
                 } 
                 curr = curr.children[childIdx];
            }
        }
		return curr.isEnd;
	}
    
    public WordDictionary() {
         this.root = new Node('/');
    }
    
    public void addWord(String word) {
        insert(word);
    }
    
    public boolean search(String word) {
        Node curr = this.root;
        return dfs(0, curr, word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
