package com.ata.data;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
	public final List<T> listEntities = new ArrayList<>();

	public boolean add(T t) {
		if (listEntities == null) {
			listEntities.add(t);
			return true;
		}
		return false;
	}

	public void delete(T t) {
		listEntities.remove(t);
	}

	public List getEntity() {
		return listEntities;
	}
	

}
