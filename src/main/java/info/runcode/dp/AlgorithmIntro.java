package info.runcode.dp;

public class AlgorithmIntro {
	 /**
	  * Our first example uses dynamic programming to solve a simple problem in deciding where to cut steel rods. Serling Enterprises buys long steel rods and cuts them
	into shorter rods, which it then sells. Each cut is free. The management of Serling
	Enterprises wants to know the best way to cut up the rods.
	We assume that we know, for i D 1; 2; : : :, the price pi in dollars that Serling
	Enterprises charges for a rod of length i inches. Rod lengths are always an integral
	number of inches. Figure 15.1 gives a sample price table
	  * @param p
	  * @param n
	  * @return
	  */
	 
	 public int cut_rob_bottom_up(int p[],int n){
		 int[] r=new int[n+1];
		 for (int i=0;i<=n;i++) {
			 r[i] = 0;
		 }
		 for(int j=0;j<n;j++) {
			 int q = Integer.MIN_VALUE;
			 for(int i=0;i<=j;i++) {
				 q = q > (r[j-i] + p[i]) ?  q : (r[j-i] + p[i]) ;
			 }
			 r[j+1] = q;
		 }
		return r[n];
		 
	 }
	 public static void main(String[] args) {
		 AlgorithmIntro p = new AlgorithmIntro();
	    	int[] input = new int[] {1,5,8,9,10,17,17,20,24,30}; //2,3,1,1,4  3,2,1,0,4
	    	for( int i=1;i<11;i++)
	    		System.out.println(i+": "+p.cut_rob_bottom_up(input,i));
	 }
}
