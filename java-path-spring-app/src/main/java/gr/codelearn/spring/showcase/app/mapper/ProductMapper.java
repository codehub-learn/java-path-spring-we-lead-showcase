package gr.codelearn.spring.showcase.app.mapper;

import gr.codelearn.spring.showcase.app.model.Product;
import gr.codelearn.spring.showcase.app.transfer.resource.ProductResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface ProductMapper extends BaseMapper<Product, ProductResource> {
}
