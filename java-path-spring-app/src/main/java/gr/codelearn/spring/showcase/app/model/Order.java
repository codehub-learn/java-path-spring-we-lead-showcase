package gr.codelearn.spring.showcase.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "ORDERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDERS_SEQ", initialValue = 1, allocationSize = 1)
public class Order extends BaseModel {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Customer customer;

	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private final Set<OrderItem> orderItems = new HashSet<>();

	@Enumerated(EnumType.STRING)
	@Column(length = 11, nullable = false)
	private OrderStatus status;

	@Enumerated(EnumType.STRING)
	@Column(length = 11, nullable = false)
	private PaymentMethod paymentMethod;

	@NotNull
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal cost;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date submitDate;
}
