package com.huayu.platform.session;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;

public class MapSession implements Session {
	private ConcurrentHashMap<String, Object> currentMap = new ConcurrentHashMap<String, Object>();

	public void put(String name, Serializable o) {
		currentMap.put(name, o);
	}

	public Object get(String name) {
		return currentMap.get(name);
	}

	public Object getAttribute(String name) {
		return get(name);
	}

	public void setAttribute(String name, Serializable o) {
		put(name, o);
	}

	public void removeAttribute(String name) {
		currentMap.remove(name);
	}

	public String getUUID() {
		return "";
	}

	public Cookie getCookie() {

		return null;
	}

	public void removeAll() {
	}

	public Map<String, Object> getAll() {

		return null;
	}

}
