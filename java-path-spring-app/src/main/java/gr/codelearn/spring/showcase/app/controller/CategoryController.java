package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.mapper.BaseMapper;
import gr.codelearn.spring.showcase.app.mapper.CategoryMapper;
import gr.codelearn.spring.showcase.app.model.Category;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.CategoryService;
import gr.codelearn.spring.showcase.app.transfer.resource.CategoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController extends BaseController<Category, CategoryResource> {
	private final CategoryService categoryService;
	private final CategoryMapper categoryMapper;

	@Override
	protected BaseService<Category, Long> getBaseService() {
		return categoryService;
	}

	@Override
	protected BaseMapper<Category, CategoryResource> getMapper() {
		return categoryMapper;
	}

}
