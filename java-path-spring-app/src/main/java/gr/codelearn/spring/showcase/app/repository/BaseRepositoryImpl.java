package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.base.BaseComponent;
import gr.codelearn.spring.showcase.app.model.BaseModel;
import gr.codelearn.spring.showcase.app.service.BaseService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class BaseRepositoryImpl<T extends BaseModel> extends BaseComponent implements BaseService<T, Long> {
	protected abstract ConcurrentHashMap<Long, T> getStorage();

	protected abstract AtomicLong getSequence();

	@Override
	public T create(final T item) {
		item.setId(getSequence().incrementAndGet());
		getStorage().put(item.getId(), item);
		return item;
	}

	@Override
	public List<T> createAll(final T... items) {
		return createAll(Arrays.asList(items));
	}

	@Override
	public List<T> createAll(final List<T> items) {
		List<T> updateItems = new ArrayList<>();
		items.forEach(i -> {
			i.setId(getSequence().incrementAndGet());
			getStorage().put(i.getId(), i);
			updateItems.add(i);
		});
		return updateItems;
	}

	@Override
	public void update(final T item) {
		getStorage().put(item.getId(), item);

	}

	@Override
	public void delete(final T item) {
		deleteById(item.getId());
	}

	@Override
	public void deleteById(final Long id) {
		getStorage().remove(id);
	}

	@Override
	public T get(final Long id) {
		return getStorage().get(id);
	}

	@Override
	public boolean exists(final T item) {
		return getStorage().containsKey(item.getId());
	}

	@Override
	public List<T> findAll() {
		return getStorage().values().stream().toList();
	}

	@Override
	public Long count() {
		return (long) getStorage().size();
	}
}
