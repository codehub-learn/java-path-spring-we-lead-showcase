package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.mapper.BaseMapper;
import gr.codelearn.spring.showcase.app.mapper.OrderMapper;
import gr.codelearn.spring.showcase.app.model.Order;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.OrderService;
import gr.codelearn.spring.showcase.app.transfer.resource.OrderResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController extends BaseController<Order, OrderResource> {
	private final OrderService orderService;
	private final OrderMapper orderMapper;

	@Override
	protected BaseService<Order, Long> getBaseService() {
		return orderService;
	}

	@Override
	protected BaseMapper<Order, OrderResource> getMapper() {
		return orderMapper;
	}
}
