package gr.codelearn.spring.showcase.app.mapper;

import gr.codelearn.spring.showcase.app.model.Category;
import gr.codelearn.spring.showcase.app.transfer.resource.CategoryResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface CategoryMapper extends BaseMapper<Category, CategoryResource> {
}
