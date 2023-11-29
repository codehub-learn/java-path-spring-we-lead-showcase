package gr.codelearn.spring.showcase.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class User {
	private String username;
	private String firstName;
	private String lastName;
	private String email;
}
