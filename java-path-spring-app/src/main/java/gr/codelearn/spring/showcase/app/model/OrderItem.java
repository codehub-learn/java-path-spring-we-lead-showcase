package gr.codelearn.spring.showcase.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class OrderItem extends BaseModel {
	private Product product;
	private Integer quantity;
	private BigDecimal price;
}
