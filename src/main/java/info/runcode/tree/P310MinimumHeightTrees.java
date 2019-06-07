package info.runcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class P310MinimumHeightTrees {
	
	    Map<Integer,Map<Integer,Integer>> cachemap = new HashMap<Integer,Map<Integer,Integer>>();
	        
	    class Edge{
	        public int p1;
	        public int p2;
	        public Edge(int p11,int p22){
	            p1 = p11;
	            p2 = p22;
	        }
	    }
	    public List<Integer> findMinHeightTreesMySelf(int n, int[][] edges) {
	        
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(edges==null || edges.length==0 || edges[0]==null || edges[0].length==0){
	            if(n==0)
	                return result;
	            else if(n==1){
	                result.add(0);
	                return result;
	            }else if(n>1){
	                return  result;
	            }
	        }
	        
	        Map<Integer,ArrayList<Integer>> depthmap = new HashMap<Integer,ArrayList<Integer>>();
	        int depthmin = Integer.MAX_VALUE;
	        for(int i=0;i<n;i++){            
	            cachemap.put(i,new HashMap<Integer,Integer>());
	        }
	        for(int i=0;i<n;i++){
	            List<Edge> ledges = new ArrayList<Edge>();
	            for(int[] edge:edges){
	                ledges.add(new Edge(edge[0],edge[1]));
	            }
	            
	            int depth = dps(ledges,i,-1);
	            //System.out.println(i+" depth:"+depth);
	            if (depthmin > depth){
	                depthmin = depth;
	            }
	            ArrayList<Integer> t = depthmap.get(depth);
	            if(t==null){
	                t = new ArrayList<Integer>();
	            }
	            t.add(i);
	            depthmap.put(depth,t);
	        }
	        
	        return depthmap.get(depthmin);
	    }
	    int dps(List<Edge> edges, int head,int from){
	        if(edges.isEmpty()){
	            return 0;
	        }
	        //System.out.println(" f:"+from+" h:"+head);
	        Integer cachev = cachemap.get(head).get(from);
	        if(cachev!=null){
	            //System.out.println("cachev:" + cachev);
	            return cachev.intValue();
	        }
	        int maxdepth = 0;
	        boolean noLeft = true;
	        while(true){
	            noLeft = true;
	            Iterator<Edge> it = edges.iterator();
	            Edge tmp = null;
	            int depth = 0;
	            while(it.hasNext()){
	                tmp = it.next();
	                if(tmp.p1 == head){
	                    edges.remove(tmp);
	                    depth = dps(edges,tmp.p2,head) + 1;
	                    noLeft = false;
	                    break;
	                }
	                if(tmp.p2 == head){
	                    edges.remove(tmp);
	                    depth = dps(edges,tmp.p1,head) + 1;
	                    noLeft = false;
	                    break;
	                }
	            }
	            if (maxdepth<depth){
	                maxdepth = depth;
	            }
	            if (noLeft) break;
	        }
	            //System.out.println("maxdepth:" + maxdepth);
	        
	        cachemap.get(head).put(from,maxdepth);
	        return maxdepth;
	    }
	    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    	HashMap<Integer,ArrayList<Integer>> emap = new HashMap<Integer,ArrayList<Integer>>();
	    	for(int[] e:edges) {
	    		emap.put(e[0], new ArrayList<Integer>());
	    	}
	    	for(int[] e:edges) {
	    		emap.get(e[0]).add(e[1]);
	    	}
	    	List<Integer> removed = new ArrayList<Integer>();
	    	while(true) {
	    		Iterator<Integer> it = emap.keySet().iterator();
	    		removed.clear();
	    		boolean last = true;
	    		while(it.hasNext()) {
	    			Integer key = it.next();
	    			ArrayList<Integer> ed = emap.get(key);
	    			if(ed.size()==1) {
	    				removed.add(key);
	    				ed.clear();
	    				last = false;
	    			}	    			
	    		}
	    		if (last) {
	    			return removed;
	    		}
	    	}
	    }
	    
}
