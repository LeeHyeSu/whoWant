package dongduk.cs.ssd.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.CategoryDao;
import dongduk.cs.ssd.dao.mybatis.mapper.CategoryMapper;
import dongduk.cs.ssd.model.Category;

@Repository
public class MybatisCategoryDao implements CategoryDao{
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<Category> getCategoryList() throws DataAccessException {
		return categoryMapper.getCategoryList();
	}

	public Category getCategory(String category) throws DataAccessException {
		return categoryMapper.getCategory(category);
	}
}
