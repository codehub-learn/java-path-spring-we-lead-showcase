package gr.codelearn.spring.showcase.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "CUSTOMERS", indexes = {@Index(columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "CUSTOMERS_SEQ", initialValue = 1, allocationSize = 1)
public class Customer extends BaseModel {
	@NotNull(message = "Email address cannot be null")
	@Email
	@Column(length = 50, nullable = false, unique = true)
	private String email;

	@NotNull(message = "First name cannot be null")
	@Column(length = 20, nullable = false)
	private String firstname;

	@NotNull(message = "Last name cannot be null")
	@Column(length = 30, nullable = false)
	private String lastname;

	@Min(value = 18, message = "A customer cannot be under 18")
	@Max(value = 120, message = "A customer cannot be above 18")
	private Integer age;

	@Column(length = 50)
	private String address;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private CustomerCategory customerCategory;
}
