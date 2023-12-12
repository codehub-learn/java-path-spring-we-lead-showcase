package gr.codelearn.spring.showcase.app.transfer.resource;

import gr.codelearn.spring.showcase.app.model.CustomerCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CustomerResource extends BaseResource {
	private String email;
	private String firstname;
	private String lastname;
	private Integer age;
	private String address;
	private CustomerCategory customerCategory;
}
