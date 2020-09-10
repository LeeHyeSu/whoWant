package dongduk.cs.ssd.service;

import java.util.Date;
import java.util.List;

import dongduk.cs.ssd.model.Project;

public interface ProjectService {

	Project getProject(int projectId);
	
	void insertProject(Project project);
	
	void updateProject(Project project);
	
	void removeProject(int projectId);
	
	List<Project> getProjectsByCategory(String category);

	List<Project> getProjectsByUsername(String username);
	
	List<Project> searchProjects(String keyword);
	
	List<Project> getProjectList();
	
	List<Project> getAllProjects();

	void ProjectScheduler(Date deadline);
}
