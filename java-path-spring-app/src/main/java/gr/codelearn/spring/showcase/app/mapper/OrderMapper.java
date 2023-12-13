package gr.codelearn.spring.showcase.app.mapper;

import gr.codelearn.spring.showcase.app.model.Order;
import gr.codelearn.spring.showcase.app.transfer.resource.OrderResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface OrderMapper extends BaseMapper<Order, OrderResource> {
}
