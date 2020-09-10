package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import dongduk.cs.ssd.model.Project;

public interface ProjectMapper {
	
	Project getProject(int projectId);
	
	List<Project> getProjectList();
	
	List<Project> getAllProjects();
	
	List<Project> getProjectsByCategory(String category);
	
	List<Project> getProjectsByUsername(String username);
	
	void insertProject(Project project);
	
	void updateProject(Project project);
	
	void updateProjectBySupport(HashMap<String, Object> map);
	
	void removeProject(int projectId);
	
	List<Project> searchProjects(String keyword);
	
	void closeProject(Date curTime);

}
