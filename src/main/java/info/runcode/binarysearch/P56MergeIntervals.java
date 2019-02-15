package info.runcode.binarysearch;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class P56MergeIntervals {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			return a.start > b.start ? 1 : a.start == b.start ? 0 : -1;
			//return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}

	}

	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());

		LinkedList<Interval> merged = new LinkedList<Interval>();
		for (Interval interval : intervals) {
			if (merged.isEmpty() || merged.getLast().end < interval.start) {
				merged.add(interval);
			} else {
				merged.getLast().end = Math.max(interval.end, merged.getLast().end);
			}
		}
		return merged;

	}

	public static void main(String[] args) {
		P56MergeIntervals p = new P56MergeIntervals();
		LinkedList<Interval> intervals = new LinkedList<Interval>();
		intervals.add(p.new Interval(1, 4));
		intervals.add(p.new Interval(0, 4));
		List<Interval> a = p.merge(intervals);
		for (Interval e : a) {
			System.out.print(e.start + " ");
			System.out.println(e.end);
		}
	}

}
