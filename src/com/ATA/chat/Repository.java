package com.ata.data;

import java.util.ArrayList;
import java.util.List;

public  class  
<T> {
	public  final List<T> listEntities = new ArrayList<>();
	
	public void add(T t) {
		listEntities.add(t);
		
	}
	
	public void delete(T t) {
		listEntities.remove(t);
	}
	public List getEntity() {
		return listEntities;
	}
}
