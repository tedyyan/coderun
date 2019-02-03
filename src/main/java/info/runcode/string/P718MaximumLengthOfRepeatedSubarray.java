package info.runcode.string;

public class P718MaximumLengthOfRepeatedSubarray {
//	718. Maximum Length of Repeated Subarray
//	Medium
//
//	522
//
//	21
//
//	Favorite
//
//	Share
//	Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
//
//	Example 1:
//	Input:
//	A: [1,2,3,2,1]
//	B: [3,2,1,4,7]
//	Output: 3
//	Explanation: 
//	The repeated subarray with maximum length is [3, 2, 1].
//	Note:
//	1 <= len(A), len(B) <= 1000
//	0 <= A[i], B[i] < 100
	
	
	public int findLength(int[] A, int[] B) {
		 int max=0;
	        int[][] samecount=new int[A.length][B.length];
	        //��ʼ����һ�е�һ��
	        for(int i=0;i<A.length;i++){
	            if(B[0]==A[i]){
	                samecount[i][0]=1;
	            }
	        }
	        for(int i=0;i<B.length;i++){
	            if(B[i]==A[0]){
	                samecount[0][i]=1;
	            }
	        }
	        //��ʼ�����һ��
	        for(int row=1;row<A.length;row++){
	            for(int col=1;col<B.length;col++){
	                if(A[row]==B[col]){
	                    //״̬ת��
	                    samecount[row][col]=samecount[row-1][col-1]+1;
	                    //ȫ�ֱȽ�
	                    max=max>samecount[row][col]?max:samecount[row][col];
	                }
	            }
	        }
	        return max;
//	--------------------- 
//	���ߣ�����320 
//	��Դ��CSDN 
//	ԭ�ģ�https://blog.csdn.net/qq_35082030/article/details/79973562 
//	��Ȩ����������Ϊ����ԭ�����£�ת���븽�ϲ������ӣ�
		

    }
}
