package info.runcode.trie;

class Trie {
	private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.value =  ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode ws = root;
    	for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (ws.children[c-'a'] == null ) {
            	TrieNode t = new TrieNode(c);
            	ws.children[c-'a'] = t;
            	ws.has_sub_word = true;            	
            }
            ws = ws.children[c-'a'];
    	}
    	ws.is_end_word = true;
    }
    
    /** Returns if the word is in the trie. */
    public TrieNode getNode(String word) {
    	TrieNode ws = root;
    
    	for(int i=0;i<word.length();i++) {
    		 char c = word.charAt(i);
    		 if (ws.children[c-'a'] == null ) {
    			 return null;
    		 }
             ws = ws.children[c-'a'];
    	}
    	
		return ws;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode ws = root;
    
    	for(int i=0;i<word.length();i++) {
    		 char c = word.charAt(i);
    		 if (ws.children[c-'a'] == null ) {
    			 return false;
    		 }
             ws = ws.children[c-'a'];
    	}
    	if (ws.is_end_word)
    	{
    		return true;
    	}
		return false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode ws = root;
        
    	for(int i=0;i<prefix.length();i++) {
    		 char c = prefix.charAt(i);
    		 if (ws.children[c-'a'] == null ) {
    			 return false;
    		 }
             ws = ws.children[c-'a'];
    	}
		return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
