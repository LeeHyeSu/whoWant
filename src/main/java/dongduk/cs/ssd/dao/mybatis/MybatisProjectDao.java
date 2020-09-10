package dongduk.cs.ssd.dao.mybatis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.dao.ProjectDao;
import dongduk.cs.ssd.dao.SequenceDao;
import dongduk.cs.ssd.dao.mybatis.mapper.ProductMapper;
import dongduk.cs.ssd.dao.mybatis.mapper.ProjectMapper;
import dongduk.cs.ssd.model.Product;
import dongduk.cs.ssd.model.Project;

@Repository
public class MybatisProjectDao implements ProjectDao {
	
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private SequenceDao sequenceDao;

	@Override
	@Transactional
	public Project getProject(int projectId) throws DataAccessException {
		Project project = projectMapper.getProject(projectId);
		if (project != null) {
			project.setProducts(productMapper.getProductsByProject(projectId));
		}
		return project;
	}

	@Override
	public List<Project> getProjectList() throws DataAccessException {
		return projectMapper.getProjectList();
	}
	
	@Override
	public List<Project> getAllProjects() throws DataAccessException {
		return projectMapper.getAllProjects();
	}
	
	@Override
	public List<Project> getProjectsByCategory(String category) throws DataAccessException {
		return projectMapper.getProjectsByCategory(category);
	}
	
	@Override
	public List<Project> getProjectsByUsername(String username) throws DataAccessException {
		return projectMapper.getProjectsByUsername(username);
	}
	
	@Override
	@Transactional
	public void insertProject(Project project) throws DataAccessException {
		project.setProjectId(sequenceDao.getNextId("projectnum"));
		project.setCurrentAmount(0);	// 현재 모인 금액 초기화
		project.setSupporterNum(0);		// 후원 인원 초기화
		project.setState("ongoing");	// 프로젝트 '진행'상태 (ongoing - 진행 / close - 마감)
		projectMapper.insertProject(project);
		for(int i = 0; i < project.getProducts().size(); i++) {
			Product product = project.getProducts().get(i);
			product.setProductId(sequenceDao.getNextId("productnum"));
			product.setProjectId(project.getProjectId());
			productMapper.insertProduct(product);
		}
	}

	@Override
	@Transactional
	public void updateProject(Project project) throws DataAccessException {
		Project prevProject = getProject(project.getProjectId()); // 수정 전 프로젝트 가져오기
		System.out.println(prevProject.getProducts());
		System.out.println(project.getProducts());
		
		HashMap<Integer, Product> modiProject = new HashMap<Integer, Product>();
		for(Product product : project.getProducts()) {		
			modiProject.put(product.getProductId(), product);
		}
		
		for(Product product : prevProject.getProducts()) {		
			int prevProductId = product.getProductId();
			if(modiProject.containsKey(prevProductId)) {		// 수정 후 프로젝트 상품에 수정 전 상품이 있을 경우 Map에서 삭제
				modiProject.remove(prevProductId);
			} else {											// 수정 후 프로젝트 상품에 수정 전 상품이 없을 경우 상품 삭제
				productMapper.removeProduct(prevProductId);
			}
		}
		
		for(Integer modiProductId : modiProject.keySet()) {		// 추가된 상품 
			Product addProduct = modiProject.get(modiProductId);
			addProduct.setProductId(sequenceDao.getNextId("productnum"));
			addProduct.setProjectId(project.getProjectId());
			productMapper.insertProduct(addProduct);
		}
//		if(prevProject.getProducts() != null) { 
//			if(!prevProject.getProducts().containsAll(project.getProducts())) { // 수정 전 프로젝트의 상품 리스트와 수정 후가 같지 않으면 상품 모두 삭제 후 추가
//				productMapper.removeProduct(project.getProjectId());
//				for(int i = 0; i < project.getProducts().size(); i++) {
//					Product product = project.getProducts().get(i);
//					product.setProductId(sequenceDao.getNextId("productnum"));
//					product.setProjectId(project.getProjectId());
//					productMapper.insertProduct(product);
//				}
//			}
//		}
		if(project.getImage().equals("default")) {	// 이미지 수정이 없을시 원래 이미지 가져오기
			project.setImage(prevProject.getImage());
		}
		projectMapper.updateProject(project);
	}

	@Override
	@Transactional
	public void removeProject(int projectId) throws DataAccessException {
		projectMapper.removeProject(projectId);		// 프로젝트 삭제
		productMapper.removeProduct(projectId);		// 프로젝트의 상품 리스트 삭제
	}

	@Override
	public List<Project> searchProjects(String keyword) throws DataAccessException {
		return projectMapper.searchProjects("%" + keyword + "%");
	}

	@Override
	public void closeProject(Date curTime) {
		projectMapper.closeProject(curTime);
	}
	
}
