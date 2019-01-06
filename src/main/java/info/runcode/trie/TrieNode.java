package info.runcode.trie;

public class TrieNode {
	public char value;
	public TrieNode[] children = new TrieNode[26];
	public boolean is_end_word = false;
	public boolean has_sub_word = false;
	public TrieNode() {}
	public TrieNode(char val) {
		value = val;
	}
}
