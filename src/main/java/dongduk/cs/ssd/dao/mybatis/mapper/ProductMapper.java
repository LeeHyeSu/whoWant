package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import dongduk.cs.ssd.model.Product;

public interface ProductMapper {

	Product getProduct(int productId);
	
	List<Product> getProductsByProject(int projectId);
	
	void insertProduct(Product product);
	
	void updateProduct(Product product);
	
	void updateProductBySupport(HashMap<String, Object> map);
	
	void removeProduct(int projectId);	// projectId 가진 상품 모두 삭제
	
}