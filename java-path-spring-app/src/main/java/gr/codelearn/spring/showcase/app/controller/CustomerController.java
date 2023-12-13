package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.mapper.BaseMapper;
import gr.codelearn.spring.showcase.app.mapper.CustomerMapper;
import gr.codelearn.spring.showcase.app.model.Customer;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.CustomerService;
import gr.codelearn.spring.showcase.app.transfer.resource.CustomerResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomerController extends BaseController<Customer, CustomerResource> {
	private final CustomerService customerService;
	private final CustomerMapper customerMapper;

	@Override
	protected BaseService<Customer, Long> getBaseService() {
		return customerService;
	}

	@Override
	protected BaseMapper<Customer, CustomerResource> getMapper() {
		return customerMapper;
	}
}
