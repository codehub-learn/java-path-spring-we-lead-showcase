package gr.codelearn.spring.showcase.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class Category extends BaseModel {
	private String description;
}
