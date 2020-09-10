package dongduk.cs.ssd.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.ProductDao;
import dongduk.cs.ssd.dao.mybatis.mapper.ProductMapper;
import dongduk.cs.ssd.model.Product;

@Repository
public class MybatisProductDao implements ProductDao {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public Product getProduct(int productId) throws DataAccessException {
		return productMapper.getProduct(productId);
	}

}
