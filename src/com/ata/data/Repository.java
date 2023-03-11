package com.ata.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class Repository<T> {
	public  List<T> listEntities = new ArrayList<>();

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

	public T getFirst (Predicate <T> predicate) {
	Optional<T> entity = listEntities.stream().filter(predicate).findFirst();
	return entity.isPresent() ? entity.get() : null;
	}
}
 