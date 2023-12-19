package gr.codelearn.spring.showcase.app.transfer.resource;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CategoryResource extends BaseResource {
	@NotNull(message = "Description cannot be null")
	private String description;
}
