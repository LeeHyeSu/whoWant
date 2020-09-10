package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.List;

import dongduk.cs.ssd.model.Category;

public interface CategoryMapper {
	
	List<Category> getCategoryList();
	
	Category getCategory(String category);
	
}
