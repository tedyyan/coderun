package info.runcode.trie;

public class P208ImplementTrie {

	
//	208. Implement Trie (Prefix Tree)
//	Medium
//
//	1247
//
//	25
//
//	Favorite
//
//	Share
//	Implement a trie with insert, search, and startsWith methods.
//
//	Example:
//
//	Trie trie = new Trie();
//
//	trie.insert("apple");
//	trie.search("apple");   // returns true
//	trie.search("app");     // returns false
//	trie.startsWith("app"); // returns true
//	trie.insert("app");   
//	trie.search("app");     // returns true
//	Note:
//
//	You may assume that all inputs are consist of lowercase letters a-z.
//	All inputs are guaranteed to be non-empty strings.
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		Boolean a = new Boolean(true);
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app"));  // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true
	}
	
}
