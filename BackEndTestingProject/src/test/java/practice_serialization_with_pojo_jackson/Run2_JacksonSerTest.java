package practice_serialization_with_pojo_jackson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project1 {

	  
	   String projectName;
	   String projectStatus;
	   int teamSize;
	   List<String> teamMember;
	   ProjectManager projectManager;
	   
	   

	    public Project1(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) 
	    {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	    }
		public void setProjectName(String projectName) {
	        this.projectName = projectName;
	    }
	    public String getProjectName() {
	        return projectName;
	    }
	    
	    public void setProjectStatus(String projectStatus) {
	        this.projectStatus = projectStatus;
	    }
	    public String getProjectStatus() {
	        return projectStatus;
	    }
	    
	    public void setTeamSize(int teamSize) {
	        this.teamSize = teamSize;
	    }
	    public int getTeamSize() {
	        return teamSize;
	    }
	    
	    public void setTeamMember(List<String> teamMember) {
	        this.teamMember = teamMember;
	    }
	    public List<String> getTeamMember() {
	        return teamMember;
	    }
	    
	    public void setProjectManager(ProjectManager projectManager) {
	        this.projectManager = projectManager;
	    }
	    public ProjectManager getProjectManager() {
	        return projectManager;
	    }
	    
	}

 class ProjectManager {

	  
	   String name;
	   String empid;


	    public ProjectManager(String name, String empid) {
		super();
		this.name = name;
		this.empid = empid;
	}
		public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return name;
	    }
	    
	    public void setEmpid(String empid) {
	        this.empid = empid;
	    }
	    public String getEmpid() {
	        return empid;
	    }
	    
	}

public class Run2_JacksonSerTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException 
	{
		List<String> lst=new ArrayList<String>();
		lst.add("Jhon");
		lst.add("David");
		lst.add("stev");
		
		ProjectManager pM=new ProjectManager("Dixit", "TY01");
		
		
		Project1 pObj=new Project1("Monster_loki", "Created", 10,lst,pM);
		ObjectMapper objM=new ObjectMapper();
		objM.writeValue(new File("./project1.json"), pObj);
		System.out.println("=====END======");
	}

}
