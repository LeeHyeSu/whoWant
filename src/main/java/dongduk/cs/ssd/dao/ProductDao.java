package dongduk.cs.ssd.dao;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.model.Product;

public interface ProductDao {
	
	Product getProduct(int productId) throws DataAccessException;

}
