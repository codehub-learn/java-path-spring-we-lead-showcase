package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
	Category findByDescription(String description);
}
