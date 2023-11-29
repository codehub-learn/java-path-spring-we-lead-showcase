package gr.codelearn.spring.showcase.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
public class OrderItem {
	private Long id;
	private String serial;
	private Integer quantity;
	private BigDecimal price;
}
