package edu.mum;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public class MyArrayList<E> extends AbstractList<E>
	implements List<E>, RandomAccess, Cloneable, java.io.Serializable{
	ArrayList<Integer> al = new ArrayList<Integer>();
	transient Object[] elementData; 
	private int size = 0;
	private int capacitysize  = 0;
	
	public MyArrayList(int initialCapacity) {
		elementData = new Object[initialCapacity];
		capacitysize =  initialCapacity;
	}
	@Override
	public E get(int index) {
		
		return (E) elementData[index];
	}
	
	private void ensureCapacityInternal(int minCapacity) {
		ensureExplicitCapacity(minCapacity);
	}
	
	private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
	
	 private void grow(int minCapacity) {
		 int oldCapacity = elementData.length;
	     int newCapacity = oldCapacity + (oldCapacity >> 1);
	     if(newCapacity - minCapacity < 0) {
	    	 newCapacity = minCapacity;
	     }
	     elementData = Arrays.copyOf(elementData, newCapacity);
		
	}
	public boolean add(E e) {
		 ensureCapacityInternal(size + 1);
		 elementData[size++] = e;
		 
		 return true;
	 }
	
	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		E oldValue = (E) elementData[index];
		elementData[index] = element;
		
		return element;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		E result = (E) elementData[index];
		modCount++;
		int outRemove = size - index - 1;
		if(outRemove>0)
			System.arraycopy(elementData, index+1, elementData, index, outRemove);
		elementData[--size] = null;
		
		return result;
	}

	private void rangeCheck(int index) {
		if(index>=size) {
			 throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
		
	}
	private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
	
	@Override
	public int size() {
		
		return size;
	}
	
	public int indexOf(Object o) {
		if(o==null) {
			
		}else {
			//need equals
		}
		return capacitysize;
		
	}
}
