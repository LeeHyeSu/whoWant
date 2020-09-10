package dongduk.cs.ssd.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import dongduk.cs.ssd.model.Category;

public interface CategoryDao {

	List<Category> getCategoryList() throws DataAccessException;

	Category getCategory(String category) throws DataAccessException;
}
