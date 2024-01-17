package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.base.BaseComponent;
import gr.codelearn.spring.showcase.app.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseModel> extends BaseComponent implements BaseService<T, Long> {
	protected abstract JpaRepository<T, Long> getRepository();

	@SafeVarargs
	@Override
	public final List<T> createAll(final T... items) {
		return createAll(Arrays.asList(items));
	}

	@Override
	public List<T> createAll(final List<T> items) {
		return getRepository().saveAll(items);
	}

	@Override
	public T create(final T item) {
		logger.trace("Creating {}.", item);
		return getRepository().save(item);
	}

	@Override
	public void update(final T item) {
		logger.trace("Updating {}.", item);
		getRepository().save(item);
	}

	@Override
	public void delete(final T item) {
		final T itemFound = getRepository().getReferenceById(item.getId());
		logger.trace("Deleting {}.", itemFound);
		getRepository().delete(itemFound);
	}

	@Override
	public void deleteById(final Long id) {
		final T itemFound = getRepository().getReferenceById(id);
		logger.trace("Deleting {}.", itemFound);
		getRepository().deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(final T item) {
		logger.trace("Checking whether {} exists.", item);
		return getRepository().existsById(item.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public T get(final Long id) {
		T item = getRepository().findById(id).orElseThrow();
		logger.trace("Item found matching id:{}.", id);
		return item;
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		logger.trace("Retrieving all items.");
		return getRepository().findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return getRepository().count();
	}
}
