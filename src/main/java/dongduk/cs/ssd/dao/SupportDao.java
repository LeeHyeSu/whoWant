package dongduk.cs.ssd.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import dongduk.cs.ssd.model.Support;

public interface SupportDao {
	
	Support getSupport(String username, String projectId) throws DataAccessException;
	
	List<Support> getSupports() throws DataAccessException;
	
	List<Support> getSupportsByProject(int projectId) throws DataAccessException;
	
	List<Support> getSupportsByUsername(String username) throws DataAccessException;
	
	void insertSupport(Support support) throws DataAccessException;

	void updateSupport(Support support) throws DataAccessException;
	
	void removeSupport(String username, int projectId) throws DataAccessException;
}
