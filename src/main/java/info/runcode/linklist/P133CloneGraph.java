package info.runcode.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P133CloneGraph {
//	133. Clone Graph
//	Medium
//
//	649
//
//	702
//
//	Favorite
//
//	Share
//	Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
//
//	 
//
//	Example:
//
//
//
//	Input:
//	{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
//
//	Explanation:
//	Node 1's value is 1, and it has two neighbors: Node 2 and 4.
//	Node 2's value is 2, and it has two neighbors: Node 1 and 3.
//	Node 3's value is 3, and it has two neighbors: Node 2 and 4.
//	Node 4's value is 4, and it has two neighbors: Node 1 and 3.
//	 
//
//	Note:
//
//	The number of nodes will be between 1 and 100.
//	The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
//	Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
//	You must return the copy of the given node as a reference to the cloned graph.
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	};
//	public Node cloneGraphHard(Node node) {
//        if(node==null) return null;
//        if((node.neighbors == null)) return new Node(node.val,node.neighbors);
//        Node placeholder = new Node(Integer.MAX_VALUE,null);
//        Node hasparent = new Node(Integer.MIN_VALUE,null);
//        Stack<Node> unreach = new Stack<Node>();
//        unreach.push(node);
//        Node clone = null,unele;
//        while(!unreach.isEmpty()){
//        	unele = unreach.pop();
//              
//            if(!isClone(unele)){
//                List<Node> a =getOrGenParent(unele,hasparent);
//                //clone
//                clone = new Node(unele.val,new ArrayList<Node>());
//                //remove parentlink
//                if(unele.neighbors.get(node.neighbors.size()-2).val==hasparent.val&&
//                   unele.neighbors.get(node.neighbors.size()-2).neighbors==hasparent.neighbors){
//                    unele.neighbors.remove(node.neighbors.size()-2);
//                    unele.neighbors.remove(node.neighbors.size()-1);
//                }
//                unele.neighbors.add(placeholder);
//                unele.neighbors.add(clone);
//                for(Node aa:a){
//                    aa.neighbors.add(clone);
//                }
//                
//            }else{
//                clone = unele.neighbors.get(node.neighbors.size()-1);
//                
//            }
//            
//            
//            //generate the connection btw parent and child
//            for(Node nb:unele.neighbors){
//                if(isClone(nb)){
//                    clone.neighbors.add(nb.neighbors.get(nb.neighbors.size()-1));                    
//                }else{
//                    //if neighbors should be put into stack
//                    unreach.push(unele);
//                    //mark is need link to parent.
//                    getOrGenParent(nb,hasparent);
//                    nb.neighbors.add(clone);
//                }
//            }
//            
//        }
//		return node.neighbors.get(node.neighbors.size()-1);
//    }
//    
//    boolean isClone(Node unreach){
//         if((unreach.neighbors==null)||(unreach.neighbors.size()<=1)){
//             return false;
//         }
//        if(unreach.neighbors.get(unreach.neighbors.size()-2).val==Integer.MAX_VALUE&&
//                   unreach.neighbors.get(unreach.neighbors.size()-2).neighbors==null
//                    ){
//            return true;
//        }
//        return false;
//    }
//    
//    List<Node> getOrGenParent(Node node, Node hasparent){
//         if((node.neighbors==null)){
//              ArrayList<Node> t = new ArrayList<Node>();
//              node.neighbors = t;
//         }
//        if(node.neighbors.size()>1){
//            if(node.neighbors.get(node.neighbors.size()-2).val==hasparent.val&&
//            		node.neighbors.get(node.neighbors.size()-2).neighbors==hasparent.neighbors
//                    ){
//                return node.neighbors.get(node.neighbors.size()-1).neighbors;
//            }
//        }
//        node.neighbors.add(hasparent);
//        node.neighbors.addAll(new ArrayList<Node>());
//        return node.neighbors;
//    }
    
    public Node cloneGraph(Node node) {
    	if(node==null) return null;
        if((node.neighbors == null)) return new Node(node.val,node.neighbors);
    	 Stack<Node> unreach = new Stack<Node>();
    	 Stack<Node> reach = new Stack<Node>();
    	 unreach.push(node);
    	 //create needle
    	 
		 while(!unreach.isEmpty()){
    		 Node tmp = unreach.pop();
    		 reach.push(tmp);
    		 Node clone = new Node(tmp.val,new ArrayList<Node>());
    		 if(tmp.neighbors==null) {
    			 tmp.neighbors = new ArrayList<Node>();
    		 }
    		 for(Node a:tmp.neighbors) {
    			 if(!reach.contains(a)&&(!unreach.contains(a)))
    				 unreach.push(a);    
    		 }
    		 tmp.neighbors.add(clone);  
    	 }
		 
		 //yinxian bianli
		 unreach.clear();
		 reach.clear();
		 unreach.push(node);
		 while(!unreach.isEmpty()){
			 Node tmp = unreach.pop();
    		 reach.push(tmp);
			 Node clone = tmp.neighbors.get(tmp.neighbors.size()-1);
    		 for(int i=0;i<tmp.neighbors.size()-1;i++) {
    			 Node srcnei = tmp.neighbors.get(i);
    			 if(!reach.contains(srcnei)&&(!unreach.contains(srcnei)))
    				 unreach.push(srcnei);
    			 
    			 clone.neighbors.add(srcnei.neighbors.get(srcnei.neighbors.size()-1));
    		 } 
		 }
		 //clear the source
		 Node result = node.neighbors.get(node.neighbors.size()-1);
		 unreach.clear();
		 reach.clear();
		 unreach.push(node);
		 while(!unreach.isEmpty()){
			 Node tmp = unreach.pop();
    		 reach.push(tmp);
			 tmp.neighbors.remove(tmp.neighbors.size()-1);
			 for(Node a:tmp.neighbors) {
    			 if(!reach.contains(a)&&(!unreach.contains(a)))
    				 unreach.push(a);
			 }
		 }
		 return result;
    }
    
    public static void main(String[] args) {
    	P133CloneGraph p = new P133CloneGraph();
    	Node node1 = p.new Node(1,new ArrayList<Node>());
    	Node node2 = p.new Node(2,new ArrayList<Node>());
    	Node node3 = p.new Node(3,new ArrayList<Node>());
    	Node node4 = p.new Node(4,new ArrayList<Node>());
    	node1.neighbors.add(node4);
    	node1.neighbors.add(node2);
    	node2.neighbors.add(node1);
    	node2.neighbors.add(node3);
    	node3.neighbors.add(node2);
    	node3.neighbors.add(node4);
    	node4.neighbors.add(node1);
    	node4.neighbors.add(node3);
    	Node a = p.cloneGraph(node1);
    	System.out.print(a.neighbors.get(0).val);
    }
    
}
