package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import dongduk.cs.ssd.model.Support;

public interface SupportMapper {

	Support getSupport(HashMap<String, Object> map);
	
	List<Support> getSupports();
	
	List<Support> getSupportsByProject(int projectId);
	
	List<Support> getSupportsByUsername(String username);
	
	void insertSupport(Support support);
	
	void updateSupport(Support support);
	
	void removeSupport(HashMap<String, Object> map);
	
}