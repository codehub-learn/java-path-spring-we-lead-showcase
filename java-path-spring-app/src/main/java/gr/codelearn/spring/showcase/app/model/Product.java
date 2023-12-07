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
public class Product extends BaseModel {
	private String name;
	private String serial;
	private BigDecimal price;
	private Category category;
}
