package gr.codelearn.spring.showcase.app.mapper;

import gr.codelearn.spring.showcase.app.model.Customer;
import gr.codelearn.spring.showcase.app.transfer.resource.CustomerResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface CustomerMapper extends BaseMapper<Customer, CustomerResource> {
}
