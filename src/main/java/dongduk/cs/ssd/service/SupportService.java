package dongduk.cs.ssd.service;

import java.util.List;

import dongduk.cs.ssd.model.Support;

public interface SupportService {
	
	Support getSupport(String username, String projectId);
	
	List<Support> getSupports();
	
	List<Support> getSupportsByProject(int projectId);
	
	List<Support> getSupportsByUsername(String username);
	
	void insertSupport(Support support);
	
	void updateSupport(Support support);
	
	void removeSupport(String username, int projectId);
	
}
