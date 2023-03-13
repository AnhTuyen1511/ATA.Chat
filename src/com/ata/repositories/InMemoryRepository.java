package com.ata.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.ata.chat.BaseEntity;

public class InMemoryRepository<T extends BaseEntity> implements Repository<T> {
	private List<T> enities;
	public static int idCounter = 1;

	public InMemoryRepository() {
		enities = new ArrayList<>();
	}

	@Override
	public boolean add(T entity) {
		if (entity == null) {
			return false;
		}
		entity.setIdIfNotExist(idCounter++);
		enities.add(entity);
		return true;
	}

	@Override
	public void delete() {
		enities.clear();
	}

	@Override
	public List<T> getListEntities() {
		return new ArrayList<>(enities);
	}

	@Override
	public T getFirst(Predicate<T> predicate) {
		Optional<T> entity = enities.stream().filter(predicate).findFirst();
		return entity.isPresent() ? entity.get() : null;
	}

	@Override
	public T getById(int id) {
		Optional<T> entity = enities.stream().filter(e -> e.getId() == id).findFirst();
		return entity.get();
	}
}
