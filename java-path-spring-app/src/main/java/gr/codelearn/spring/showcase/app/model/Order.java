package gr.codelearn.spring.showcase.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class Order extends BaseModel {
	private Customer customer;
	private final Set<OrderItem> orderItems = new HashSet<>();
	private Date submitDate;
	private OrderStatus status;
	private PaymentMethod paymentMethod;
	private BigDecimal cost;

}
