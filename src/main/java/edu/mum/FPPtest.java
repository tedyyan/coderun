package edu.mum;

public class FPPtest {
	public static void main(String[] args) {
		//System.out.print(isPerfectSquare(16));
		//System.out.print(guthrieIndex(42));
		System.out.print(solve101()[0] + " " +solve101()[1]+" " +solve101()[2]);
		System.out.print(solve101()[0]);
	}
	static int  isPerfectSquare(int n){
		if(n<0) return 0;
		if(n==0) return 1;
		int fromit = (int) Math.sqrt(n);
		return fromit+1;
	}
	
	static int guthrieIndex(int n){
		if(n<=0) return -1;
		int cnt=0;
		while(n!=1){
			if((n&0x01)==0){
				n = n / 2;
			}else{
				n = n * 3;
				n++;
			}
			cnt++;
			System.out.println(n);
		}
		return cnt;
	}
	
	static int[ ] solve10(){
		int[] all = new int[10];
		all[0] = 1;
		for(int i=1;i<10;i++){
			all[i] = all[i-1]*(i+1);
			System.out.print(" "+all[i]);
		}
		for(int i=1;i<10;i++){
			for(int j=i;j>=0;j--){
				int tmp = all[i] + all[j] ;
				if(tmp == all[9]){
					return new int[]{i+1,j+1};
				}else if(tmp < all[9]){
					break;
				}
			}
		}
		return null;
	}
	
	
	
	public static int[] solve101() {

        int n = 1;
        int m = 10;
        int a = 1 ;
        int b = 1;
        int k = 1;

        int[] z = new int[3];

        for (int i = 1; i <= m; i++) {
            n *= i;
        }

        while (k <= m) {

            a = a *  k;
            b = 1;

            for (int j = 1; j <= m; j++) {
                b = b * j;
                if (a + b == n) {
                    z[0] = k;
                    z[1] = j;
                    z[2] = n;
                    return z;
                }

            }
            k++;
        }

        return z;
    }
}
