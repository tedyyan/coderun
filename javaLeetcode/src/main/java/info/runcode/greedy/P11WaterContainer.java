package info.runcode.greedy;


public class P11WaterContainer {
	
//	11. Container With Most Water
//	Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
//	n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
//	which together with x-axis forms a container, such that the container contains the most water.
//
//	Note: You may not slant the container and n is at least 2.
//	
//	Example:
//
//		Input: [1,8,6,2,5,4,8,3,7]
//		Output: 49
	
    public int maxArea(int[] h) {
    	if (h==null) return 0;
    	if (h.length<=1) {
    		return 0;
    	}
    	
		int s=0;
		int e=h.length-1;
		int max =(h[e]<h[s]?h[e]:h[s])*(e-s);
    	while(e>s) {
    		int nmax = (h[e]<h[s]?h[e]:h[s])*(e-s);
    		if (nmax>max) {
    			max = nmax;
    		}
    		if (h[s]<h[e]) {    			
    			s++;
    		}else {
    			e--;
    		}
    	}
		return max;
        
    }
    
	 public static void main(String[] args) {
		 P11WaterContainer p = new P11WaterContainer();
		 int[] input = new int[] {1,2}; //2,3,1,1,4  3,2,1,0,4 2,7,9,3,1 2,3,2
		 System.out.println(p.maxArea(input));
		 
	 }
}
