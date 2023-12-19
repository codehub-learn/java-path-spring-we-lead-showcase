package gr.codelearn.spring.showcase.app.transfer.resource;

import gr.codelearn.spring.showcase.app.model.CustomerCategory;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CustomerResource extends BaseResource {
	@NotNull(message = "Email cannot be null")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "The email format is not correct")
	private String email;

	@NotNull(message = "Firstname cannot be null")
	private String firstname;

	@NotNull(message = "Lastname cannot be null")
	private String lastname;

	@Min(value = 12, message = "A customer's age cannot be under 12")
	@Max(value = 120, message = "A customer's age cannot be above 120")
	private Integer age;

	@Size(max = 50, message = "Address cannot be longer than 50 characters")
	private String address;

	@NotNull
	private CustomerCategory customerCategory;
}
