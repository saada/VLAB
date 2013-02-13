package edu.asu.snac.shared;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum UUIDPool {
	instance;

	public static UUIDPool getInstance() {
		return instance;
	}

	private ConcurrentMap<String, Boolean> mIds;

	UUIDPool() {
		mIds = new ConcurrentHashMap<String, Boolean>();
	}

	public String getId() {
		String uuid = null;
		do {
			uuid = UUID.randomUUID().toString();
		} while (instance.mIds.putIfAbsent(uuid, true) != null);
		return uuid;
	}

	public void removeId(String id) {
		mIds.remove(id);
	}
}