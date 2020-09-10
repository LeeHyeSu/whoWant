package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.CategoryDao;
import dongduk.cs.ssd.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public CategoryServiceImpl() {}

	@Override
	public Category getCategory(String category) {
		return categoryDao.getCategory(category);
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

}
