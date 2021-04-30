package info.runcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class P692TopKFrequentWords {

	public static void main(String[] args) {
		P692TopKFrequentWords test = new P692TopKFrequentWords();
		ArrayList<String> al = new ArrayList<String>();
		al.add("i");
		al.add("love");
		al.add("leetcode");
		al.add("i");
		al.add("love");
		al.add("coding");
		List<String> b = test.topKFrequentByHeap(new String[] { "the", "day", "is", "sunny", "zhe", "zhe1", "zhe11",
				"zhe11", "the1", "the", "the", "sunny", "is", "is" }, 5);
		// "i", "love","leetcode", "i", "love", "coding"},2);
		System.out.println(b);

		b = test.topKFrequent(new String[] { "the", "day", "is", "sunny", "zhe", "zhe1", "zhe11", "zhe11", "the1",
				"the", "the", "sunny", "is", "is" }, 5);
		// "i", "love","leetcode", "i", "love", "coding"},2);
		System.out.println(b);

		b = test.topKFrequentBySet(new String[] { "the", "day", "is", "sunny", "zhe", "zhe1", "zhe11", "zhe11", "the1",
				"the", "the", "sunny", "is", "is" }, 5);
//"i", "love","leetcode", "i", "love", "coding"},2);
		System.out.println(b);
		// "the", "day", "is", "sunny", "zhe", "zhe1", "zhe11", "zhe11","the1", "the",
		// "the", "sunny", "is", "is"},4);
		// "i", "love","leetcode", "i", "love", "coding"}, 2);
		// test.topKFrequent(al.toArray(new String[0]), 2);
		/*
		 * ArrayList<Integer> d = new ArrayList<Integer>(); d.add(12); d.add(14);
		 * d.add(11); d.add(13); d.add(10); //int aa = test.RS(d, 0, d.size()-1,4); int
		 * aa = test.findKfromList(d, 5, 0, d.size()-1); System.out.println(aa); aa =
		 * test.findKfromList(d, 4, 0, d.size()-1); System.out.println(aa); aa =
		 * test.findKfromList(d, 3, 0, d.size()-1); System.out.println(aa); aa =
		 * test.findKfromList(d, 2, 0, d.size()-1); System.out.println(aa); aa =
		 * test.findKfromList(d, 1, 0, d.size()-1); System.out.println(aa);
		 */
	}

	class StrCntCompro {
		int cnt = 0;
		String str = "";

		StrCntCompro(int cnt, String str) {
			this.cnt = cnt;
			this.str = str;
		}
	}

	public List<String> topKFrequentByHeap(String[] words, int k) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		for (String word : words) {
			count.put(word, count.getOrDefault(word, 0) + 1);
		}

		Iterator<String> it = count.keySet().iterator();
		PriorityQueue<StrCntCompro> rr = new PriorityQueue<StrCntCompro>(new Comparator<StrCntCompro>() {

			@Override
			public int compare(StrCntCompro wf1, StrCntCompro wf2) {
				if (wf1.cnt == wf2.cnt) {
                    return wf2.str.compareTo(wf1.str);
                } else {
                    return Integer.compare(wf1.cnt, wf2.cnt);
                }
			}

		});
		while (it.hasNext()) {
			String strval = it.next();
			int intv = count.get(strval).intValue();
			rr.offer(new StrCntCompro(intv, strval));
			if (rr.size() > k) {
				rr.poll();
			}
		}
		List<String> ans = new LinkedList<>();
		while (!rr.isEmpty()) {
			StrCntCompro wf = rr.poll();
            ans.add(0, wf.str);
        }
		return ans;
	}

	public List<String> topKFrequentBySet(String[] words, int k) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		for (String word : words) {
			count.put(word, count.getOrDefault(word, 0) + 1);
		}

		Iterator<String> it = count.keySet().iterator();
		TreeSet<StrCntCompro> rr = new TreeSet<StrCntCompro>(new Comparator<StrCntCompro>() {

			@Override
			public int compare(StrCntCompro o1, StrCntCompro o2) {
				if (o1.cnt > o2.cnt)
					return -1;
				if (o1.cnt < o2.cnt)
					return 1;
				return o1.str.compareTo(o2.str);
			}

		});
		while (it.hasNext()) {
			String strval = it.next();
			int intv = count.get(strval).intValue();
			// if (intv >= a) {
			rr.add(new StrCntCompro(intv, strval));
			if (rr.size() > k) {
				rr.remove(rr.last());
			}
			// }
		}
		List<String> result = new ArrayList<String>();
		Iterator<StrCntCompro> itset = rr.iterator();
		int c = 0;
		while (itset.hasNext() && c < k) {
			result.add(itset.next().str);
			c++;
		}
		return result;
	}

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		for (String word : words) {
			count.put(word, count.getOrDefault(word, 0) + 1);
		}
		HashSet<Integer> al = new HashSet<Integer>(count.values());
		int m = 0, n = al.size() - 1;
		Integer[] b = al.toArray(new Integer[0]);
		int a = findKfromList(Arrays.asList(b), k, m, n);

		Iterator<String> it = count.keySet().iterator();
		TreeSet<StrCntCompro> rr = new TreeSet<StrCntCompro>(new Comparator<StrCntCompro>() {

			@Override
			public int compare(StrCntCompro o1, StrCntCompro o2) {
				if (o1.cnt > o2.cnt)
					return -1;
				if (o1.cnt < o2.cnt)
					return 1;
				return o1.str.compareTo(o2.str);
			}

		});
		while (it.hasNext()) {
			String strval = it.next();
			int intv = count.get(strval).intValue();
			if (intv >= a) {
				rr.add(new StrCntCompro(intv, strval));
			}
		}
		List<String> result = new ArrayList<String>();
		Iterator<StrCntCompro> itset = rr.iterator();
		int c = 0;
		while (itset.hasNext() && c < k) {
			result.add(itset.next().str);
			c++;
		}
		return result;
	}

	/*
	 * al can't have duplicate element
	 */
	public int findKfromList(List<Integer> al, int k, int m, int n) {

		// System.out.println(al);
		// System.out.println("k: " +k +" m: "+m+" n: "+n);
		if (m == n)
			return al.get(n);
		if (k == 0)
			return al.get(m - 1);
		int oldm = m;
		int oldn = n;
		int mid = al.get(m);
		int i = 1;
		while (true) {
			while (m <= n) {
				if (al.get(n) < mid) {
					n--;
					if (n < 0)
						break;
				} else if (al.get(m) >= mid) {
					m++;
					if (m > oldn)
						break;
				} else {
					int t = al.get(m);
					al.set(m, al.get(n));
					al.set(n, t);
					n--;
					m++;
				}
			}
			if (m == oldn + 1) {
				mid = al.get(oldm + i);
				m = oldm;
				n = oldn;
				i++;
			} else {
				break;
			}
		}

		if ((m == n) && (al.get(m) >= mid)) {
			m = m + 1;
		}
		// System.out.println("splitpoint: " +splitpoint +" m: "+m+" n: "+n);
		if (k > (m - oldm)) {
			return findKfromList(al, k - (m - oldm), m, oldn);
		} else if (k == m - oldm) {
			return mid;
		} else {
			return findKfromList(al, k, oldm, m - 1);
		}
	}

	int RS(ArrayList<Integer> al, int low, int high, int k) {

		if (low == high)
			return al.get(low);

		int i = partition(al, low, high);

		int temp = i - low; // 数组前半部分元素个数

		if (temp >= k)

			return RS(al, low, i - 1, k); // 求前半部分第k大

		else

			return RS(al, i + 1, high, k - i); // 求后半部分第k-i大

	}

	private int partition(ArrayList<Integer> al, int low, int high) {

		int mid = al.get(low);
		while (low <= high) {
			if (al.get(high) < mid) {
				high--;
			} else if (al.get(low) >= mid) {
				low++;
			} else {
				int t = al.get(low);
				al.set(low, al.get(high));
				al.set(high, t);
				high--;
				low++;
			}
		}
		if ((low == high) && (al.get(low) >= mid)) {
			low = low + 1;
		}
		return low;
	}
}
