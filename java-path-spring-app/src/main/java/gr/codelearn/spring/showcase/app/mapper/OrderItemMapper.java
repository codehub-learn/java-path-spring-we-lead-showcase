package gr.codelearn.spring.showcase.app.mapper;

import gr.codelearn.spring.showcase.app.model.OrderItem;
import gr.codelearn.spring.showcase.app.transfer.resource.OrderItemResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface OrderItemMapper extends BaseMapper<OrderItem, OrderItemResource> {
}
