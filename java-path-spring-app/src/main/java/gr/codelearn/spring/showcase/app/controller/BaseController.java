package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.base.BaseComponent;
import gr.codelearn.spring.showcase.app.mapper.BaseMapper;
import gr.codelearn.spring.showcase.app.model.BaseModel;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import gr.codelearn.spring.showcase.app.transfer.resource.BaseResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public abstract class BaseController<T extends BaseModel, R extends BaseResource> extends BaseComponent {
	protected abstract BaseService<T, Long> getBaseService();

	protected abstract BaseMapper<T, R> getMapper();

	@GetMapping("{id}")
	public ResponseEntity<ApiResponse<R>> get(@PathVariable("id") final Long id) {
		return ResponseEntity.ok(
				ApiResponse.<R>builder()
						   .data(getMapper().toResource(getBaseService().get(id)))
						   .build());
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<R>>> findAll() {
		return ResponseEntity.ok(
				ApiResponse.<List<R>>builder()
						   .data(getMapper().toResources(getBaseService().findAll()))
						   .build());
	}

	@PostMapping
	public ResponseEntity<ApiResponse<R>> create(@RequestBody final R resource) {
		var domain = getBaseService().create(getMapper().toDomain(resource));
		return new ResponseEntity<>(
				ApiResponse.<R>builder()
						   .data(getMapper().toResource(domain))
						   .build(),
				HttpStatus.CREATED);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody final R resource) {
		getBaseService().update(getMapper().toDomain(resource));
	}


}