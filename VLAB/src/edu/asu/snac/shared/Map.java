package edu.asu.snac.shared;

import java.util.Hashtable;

public class Map<K, T> {
	protected Hashtable<K, T> map;

	public Map() {
		map = new Hashtable<K, T>();
	}

	public synchronized T get(K key) {
		return map.get(key);
	}

	public synchronized T put(K key, T value) {
		return map.put(key, value);
	}

	public synchronized T remove(K key) {
		return map.remove(key);
	}
}
