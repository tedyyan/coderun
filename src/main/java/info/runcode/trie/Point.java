package info.runcode.trie;

import com.google.common.base.Objects;

public class Point<T extends Comparable> implements Comparable <Point<T >>{
	T x;
	T y;
	@Override
	public int compareTo(Point<T>  o) {
		if (this == o) {
			return 0;
		}
		if (Objects.equal(this.x, o.x) && Objects.equal(this.y, o.y)){
			return 0;
		}else if (this.x.compareTo(o.x)>0){
			return 1;
		}else if (this.y.compareTo(o.y)>0) {
			return 1;
		}
		return -1;
	}
	@Override
	public boolean equals(Object o) {
		// self check
	    if (this == o)
	        return true;
	    // null check
	    if (o == null)
	        return false;
	    // type check and cast
	    if (getClass() != o.getClass())
	        return false;
	    Point<T> point = (Point<T>) o;	    
	    
		return Objects.equal(this.x, point.x) && Objects.equal(this.y, point.y) ;
	}
	
	@Override
	public int hashCode() {
		return (this.x.hashCode() << 8) + this.y.hashCode();
	}
	
	public Point(T x,T y){
		this.x = x;
		this.y = y;
	}

}
