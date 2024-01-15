package gr.codelearn.spring.showcase.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "PRODUCTS", indexes = {@Index(columnList = "serial")})
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
public class Product extends BaseModel {
	@NotNull
	@Column(length = 50, nullable = false)
	private String name;

	@NotNull
	@Column(length = 30, nullable = false, unique = true)
	private String serial;

	@NotNull
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal price;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
}
