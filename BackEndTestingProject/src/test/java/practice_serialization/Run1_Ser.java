package practice_serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable
{
	
	String name;
	int level;
	long score;
	int life;
	public NFSGame(String name, int level, long score, int life) 
	{
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	
	
}

public class Run1_Ser 
{
	public static void main(String[] args) throws Throwable 
	{
		NFSGame user1Obj=new NFSGame("Monster", 20, 100000, 3);
		FileOutputStream fileOut=new FileOutputStream("./f.txt");
				
		ObjectOutputStream objOut=new ObjectOutputStream(fileOut);
		objOut.writeObject(user1Obj);
		System.out.println("=========End=============");
		
	}

}
