package practice_serialization_with_pojo_jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder
(
		value= {"createdBy",
				"projectName",
				"teamSize",
				"status"
				}
)

@JsonIgnoreProperties
(
		value= {
				"teamSize"
				},allowSetters = true
		
)


class Project //POJO class(Plain old java object)
{
	private String projectName;
	@JsonProperty(value="Created By")
	private String createdBy;
	private int teamSize;
	private String status;
	
	private Project()
	{
		
	}
	public Project(String projectName, String createdBy, int teamSize, String status) 
	{
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

public class Run1_JacksonSerTest 
{
	public static void main(String[] args) throws Throwable, DatabindException, IOException 
	{
		Project pObj=new Project("Monster","DADA", 10, "Created");
		
		ObjectMapper objM =new ObjectMapper();
		objM.writeValue(new File("./project.json"), pObj);
		
		System.out.println("======end======");
		
	}


	
}
