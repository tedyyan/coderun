package info.runcode.string;

//Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
//
//		For example, with A = "abcd" and B = "cdabcdab".
//
//		Return 3, because by repeating A three times (¡°abcdabcdabcd¡±), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
//
//		Note:
//		The length of A and B will be between 1 and 10000.
public class P686RepeatedStringPattern {

	public int repeatedStringMatch2(String A, String B) {
		if ((A == null) || (B == null))
			return -1;
		int a = A.length();
		int b = B.length();
		if ((a == 0) && (b > 0))
			return -1;
		if (b == 0)
			return 1;
		String aa = String.copyValueOf(A.toCharArray());
		int r = 1;
		while (b > a) {
			a = a + A.length();
			r++;
			aa = aa + A;
		}
		int k = 0;
		while (aa.indexOf(B) < 0) {
			aa = aa + A;
			r++;
			k++;
			if (k == 2) {
				return -1;
			}
		}
		return r;
	}
	
	int repeatedStringMatch(String A, String B) {
        int m = A.length(), n = B.length();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i = 0; i < m; ++i) {
            int j = 0;
            while (j < n && a[(i + j) % m] == b[j]) ++j;
            if (j == n) return (i + j - 1) / m + 1;
        }
        return -1;
    }
}
