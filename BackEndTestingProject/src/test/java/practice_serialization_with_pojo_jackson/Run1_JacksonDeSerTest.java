package practice_serialization_with_pojo_jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Run1_JacksonDeSerTest 
{
	public static void main(String[] args) throws Throwable, DatabindException, IOException 
	{
		ObjectMapper objM =new ObjectMapper();
		Project pObj=objM.readValue(new File("./project.json"), Project.class);//deserialization
		
		System.out.println(pObj.getProjectName());
		System.out.println(pObj.getCreatedBy());
		System.out.println(pObj.getTeamSize());
		System.out.println(pObj.getStatus());
		System.out.println("======end======");
		
	}


	
}
