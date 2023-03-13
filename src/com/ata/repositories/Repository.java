package com.ata.repositories;

import java.util.List;
import java.util.function.Predicate;

public interface Repository<T> {

	public boolean add(T t);

	public void delete();

	public T getFirst(Predicate<T> predicate);

	T getById(int id);

	List<T> getListEntities();
	
}
