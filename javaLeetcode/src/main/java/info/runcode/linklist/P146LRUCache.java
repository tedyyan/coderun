package info.runcode.linklist;

import java.util.HashMap;

public class P146LRUCache {

	public static void main(String[] args) {
		P146LRUCache cache = new P146LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));        // returns -1 (not found)
		System.out.println(cache.get(3));        // returns 3
		System.out.println(cache.get(4));        // returns 4
	}
	
	private class LinkedListNode {
		public int key;
		public int val;

		LinkedListNode next;
		LinkedListNode previous;
		public LinkedListNode(int k, int v) {
			this.key = k;
			this.val = v;
		}
	}
	
	class MyLinkedList {
		public int Count;
		public LinkedListNode Last = null;
		public LinkedListNode Head = null;

		public LinkedListNode AddFirst(LinkedListNode linkedListNode) {
			if(Head==null) {
				Head = linkedListNode;
				Last = Head;
			}else {
				linkedListNode.next =  Head;
				Head.previous = linkedListNode;
				this.Head = linkedListNode;
				linkedListNode.previous = null;
			}
			Count++;

			return linkedListNode;
		}

		public void RemoveLast() {
			if (Last.previous==null) {
				Head = null;
				Last = null;
				Count = 0;
				return ;
			}
			Last.previous.next =  null;
			Last = Last.previous;
			Count--;
		}

		public void Remove(LinkedListNode node) {
			if(node.previous==null && node.next == null) {
				Head = null;
				Last = null;
				Count = 0;
				return;
			}
			if (node.previous!=null) 
				node.previous.next = node.next;
			else
				this.Head = node.next;
			if (node.next!=null)
				node.next.previous =  node.previous;
			else
				this.Last = node.previous;
			
			Count--;
		}

	}

	HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
	MyLinkedList list = new MyLinkedList();
	private int capacity;

	public P146LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;

		LinkedListNode node = map.get(key);
		MoveToFirst(node);

		return node.val;
	}

	public void put(int key, int value) {
		if (!map.containsKey(key)) {
			LinkedListNode node = list.AddFirst(new LinkedListNode(key, value));
			map.put(key, node);

			if (list.Count > this.capacity) {
				Object k = list.Last.key;
				list.RemoveLast();
				map.remove(k);
			}
		} else {
			map.get(key).val = value;
			LinkedListNode node = map.get(key);

			MoveToFirst(node);
		}

	}

	private void MoveToFirst(LinkedListNode node) {
		list.Remove(node);
		list.AddFirst(node);
	}


}
