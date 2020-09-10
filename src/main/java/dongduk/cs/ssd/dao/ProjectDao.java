package dongduk.cs.ssd.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.model.Project;

public interface ProjectDao {
	
	Project getProject(int projectId) throws DataAccessException;

	List<Project> getProjectList() throws DataAccessException;
	
	List<Project> getAllProjects() throws DataAccessException;
	
	List<Project> getProjectsByCategory(String category) throws DataAccessException;
	
	List<Project> getProjectsByUsername(String username) throws DataAccessException;
	
	void insertProject(Project project) throws DataAccessException;
	
	void updateProject(Project project) throws DataAccessException;
	
	void removeProject(int projectId) throws DataAccessException;

	List<Project> searchProjects(String keyword) throws DataAccessException;

	void closeProject(Date curTime);
}
