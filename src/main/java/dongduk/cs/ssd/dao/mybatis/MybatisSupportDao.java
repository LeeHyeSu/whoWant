package dongduk.cs.ssd.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.dao.SupportDao;
import dongduk.cs.ssd.dao.mybatis.mapper.ProductMapper;
import dongduk.cs.ssd.dao.mybatis.mapper.ProjectMapper;
import dongduk.cs.ssd.dao.mybatis.mapper.SupportMapper;
import dongduk.cs.ssd.model.Support;

@Repository
public class MybatisSupportDao implements SupportDao {
	
	@Autowired
	private SupportMapper supportMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public Support getSupport(String username, String projectId) throws DataAccessException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("projectId", Integer.parseInt(projectId));
		
		return supportMapper.getSupport(map);
	}

	@Override
	public List<Support> getSupports() throws DataAccessException {
		return supportMapper.getSupports();
	}
	
	@Override
	public List<Support> getSupportsByProject(int projectId) throws DataAccessException {
		return supportMapper.getSupportsByProject(projectId);
	}

	@Override
	public List<Support> getSupportsByUsername(String username) throws DataAccessException {
		return supportMapper.getSupportsByUsername(username);
	}
	
	@Transactional
	public void insertSupport(Support support) throws DataAccessException {
		supportMapper.insertSupport(support);
		
		HashMap<String, Object> projectMap = new HashMap<String, Object>();
		projectMap.put("amount", support.getAmount());
		projectMap.put("num", 1);
		projectMap.put("projectId", support.getProjectId());
		
		projectMapper.updateProjectBySupport(projectMap);	// 프로젝트 현재금액과 후원자수 업데이트
	
		if(support.getProductId() != 0) {	// 선택한 상품이 있는 경우
			HashMap<String, Object> productMap = new HashMap<String, Object>();
			productMap.put("member", 1);
			if(productMapper.getProduct(support.getProductId()).getQuantity() == -1) {
				productMap.put("quantity", 0);
			} else {
				productMap.put("quantity", -1);
			}
			productMap.put("productId", support.getProductId());
			
			productMapper.updateProductBySupport(productMap);	// 선택한 상품 업데이트
		}
		
	}

	@Override
	public void updateSupport(Support support) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void removeSupport(String username, int projectId) throws DataAccessException {
		// 삭제할 후원 정보 저장해두고 후원 정보 삭제
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("projectId", projectId);
		
		Support support = supportMapper.getSupport(map);
		supportMapper.removeSupport(map);
		
		// 저장해둔 후원 정보를 이용해 프로젝트 현재금액과 후원자수 업데이트
		HashMap<String, Object> projectMap = new HashMap<String, Object>();
		projectMap.put("amount", support.getAmount() * (-1));
		projectMap.put("num", -1);
		projectMap.put("projectId", support.getProjectId());
		
		projectMapper.updateProjectBySupport(projectMap);	
		
		// 선택한 상품이 있는 경우 상품을 선택한 후원자수와 수량 업데이트
		if(support.getProductId() != 0) {
			HashMap<String, Object> productMap = new HashMap<String, Object>();
			productMap.put("member", -1);
			if(productMapper.getProduct(support.getProductId()).getQuantity() == -1) {
				productMap.put("quantity", 0);
			} else {
				productMap.put("quantity", 1);
			}
			productMap.put("productId", support.getProductId());
			
			productMapper.updateProductBySupport(productMap);	// 후원할 상품 업데이트
		}
	}

}
