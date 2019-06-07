package info.runcode.lcmatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Snippet {
		public String gcdOfStrings(String str1, String str2) {
			int t = getGCD(str1.length(), str2.length());
			String result = "";
			// System.out.println(t);
			if (t > 1) {
				result = str2.substring(0, t);
				// System.out.println("result:"+result);
				for (int i = 0; i < str1.length() / t; i++) {
					// System.out.println("---");
					// System.out.println(str1.substring(i*t,i*t+t));
					if (!str1.substring(i * t, i * t + t).equals(result)) {
						// System.out.println("--111-");
						return "";
					}
				}
				for (int i = 0; i < str2.length() / t; i++) {
					// System.out.println(str2.substring(i*t,i*t+t));
					if (!str2.substring(i * t, i * t + t).equals(result)) {
						return "";
					}
				}
			}
			return result;
		}
	
		public static int getGCD(int a, int b) {
			if (a < 0 || b < 0) {
				return -1; // 数学上不考虑负数的约数
			}
			if (b == 0) {
				return a;
			}
			return a % b == 0 ? b : getGCD(b, a % b);
		}
	
		public static int maxEqualRowsAfterFlips(int[][] matrix) {
			int max = 0;
			for (int i = 0; i < matrix.length; i++) {
				int tmpmaxall = 0;
				int tmpmaxreverse = 0;
				for (int j = 0; j < matrix.length; j++) {
					if (i != j) {
						boolean allreverse = true;
						boolean allsame = true;
						for (int m = 0; m < matrix[0].length; m++) {
							if (matrix[i][m] + matrix[j][m] != 1) {
								allreverse =  false;
							}
							if (matrix[i][m] != matrix[j][m] ) {
								allsame =  false;
							}
						}
						if (allreverse)
							tmpmaxreverse++;
						if (allsame)
							tmpmaxall++;
					}
				}
				max = max > tmpmaxreverse + tmpmaxall ? max : tmpmaxreverse+ tmpmaxall;
			}
			return max+1;
		}
		
		  public static int[] addNegabinary(int[] arr1, int[] arr2) {
		        int maxlen = arr1.length > arr2.length ? arr1.length :arr2.length ;
		        int[] tmp = new int[maxlen];
		        for(int i=maxlen-1;i>=0;i--){
		            if(i>arr1.length-1){
		                tmp[i] =  arr2[i];
		            }else if(i>arr2.length-1){
		                tmp[i] =  arr1[i];
		            }else{
		                tmp[i] = arr1[i]+arr2[i];
		            }
		        }		
		       //for(int i=0;i<tmp.length;i++)
				//	System.out.println(tmp[i]);
		        //System.out.println("111111111111");
		        
		        int[] result= new int[maxlen + 1];
		        for(int j=0;j<=tmp.length-1;j++){
		            if (tmp[j]==2){
		            	if(j+1<tmp.length) {
		            		if(tmp[j+1]>0) {
			            		tmp[j+1] = tmp[j+1]-1;
			                	tmp[j]=0;
		            		}else {
		            			
		            		}
		            	}else {
		            		
		            	}
		            }
		            result[j] = tmp[j];
		        }
		        //for(int i=0;i)
		        if(result[maxlen-1]==2) {
		        	result[maxlen-1] = 0;
		        	result[maxlen] = 1;
		        }
		        int skip  =  0;
		        for(int i=maxlen;i>=0;i--) {
		        	if(result[i] == 0) {
		        		skip++;
		        	}else {
		        		break;
		        	}
		        }
		        //for(int i=0;i<result.length;i++)
				//	System.out.println(result[i]);
		        //System.out.println("111111111111:" + skip);
		        int[] rr = new int[maxlen + 1 - skip];
		        for(int  i=0;i< maxlen + 1 - skip;i++) {
		        	rr[maxlen + 1 -skip -1 -i] = result[i];
		        }
		        return  rr;
		    }
		  
		  
}

