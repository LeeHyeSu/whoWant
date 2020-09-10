package dongduk.cs.ssd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.ProductDao;
import dongduk.cs.ssd.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}

}
