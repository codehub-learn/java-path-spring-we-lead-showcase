package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.base.BaseComponent;
import gr.codelearn.spring.showcase.app.model.BaseModel;
import gr.codelearn.spring.showcase.app.repository.BaseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class BaseServiceImpl<T extends BaseModel> extends BaseComponent implements BaseService<T, Long> {
	protected abstract BaseRepository<T, Long> getRepository();

	@Override
	public T create(final T item) {
		return getRepository().create(item);
	}

	@Override
	public List<T> createAll(final T... items) {
		return createAll(Arrays.asList(items));
	}

	@Override
	public List<T> createAll(final List<T> items) {
		return getRepository().createAll(items);
	}

	@Override
	public void update(final T item) {
		getRepository().update(item);

	}

	@Override
	public void delete(final T item) {
		getRepository().delete(item);
	}

	@Override
	public void deleteById(final Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public T get(final Long id) {
		if (getRepository().get(id) == null) {
			throw new NoSuchElementException(String.format("Resource with id [%d] not found", id));
		}
		return getRepository().get(id);
	}

	@Override
	public boolean exists(final T item) {
		return getRepository().exists(item);
	}

	@Override
	public List<T> findAll() {
		return getRepository().findAll();
	}

	@Override
	public Long count() {
		return getRepository().count();
	}
}
