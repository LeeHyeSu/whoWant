package dongduk.cs.ssd.service;

import java.util.List;

import dongduk.cs.ssd.model.Category;

public interface CategoryService {
	
	Category getCategory(String category);
	
	List<Category> getCategoryList();
	
}
