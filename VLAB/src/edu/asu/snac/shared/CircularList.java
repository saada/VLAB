package edu.asu.snac.shared;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CircularList<T> {
	private ArrayList<T> list;
	private int lastIndex;
	private int size;

	public CircularList(int size) {
		this.size = size;
		list = new ArrayList<T>();
		lastIndex = 0;
	}

	public synchronized void add(T data) {
		increasementLastIndex();
		if (list.size() <= lastIndex) {
			list.add(lastIndex, data);
		} else {
			list.set(lastIndex, data);
		}
	}

	public synchronized List<T> getRange(int start) {
		if (start >= size) {
			throw new IllegalArgumentException("");
		}

		LinkedList<T> ret = new LinkedList<T>();

		if (start <= lastIndex) {
			for (int i = start; i <= lastIndex; i++) {
				ret.add(list.get(i));
			}
		} else {
			int i = start;
			while (i % size <= lastIndex) {
				ret.add(list.get(i));
				i++;
			}
		}
		return ret;
	}

	private void increasementLastIndex() {
		lastIndex++;
		if (lastIndex >= size) {
			lastIndex = 0;
		}
	}
}
