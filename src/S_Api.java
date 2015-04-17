import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import main.java.riotapi.RiotApi;


public class S_Api extends RiotApi {
	static private S_Api instance = null ;
	public static final String API_KEY = "96046f24-9b56-433e-b060-266bf75f484b";
	
	static S_Api getInstance(){
		if(instance == null){
//			try{
////				load();
//			}catch(Exception E){
				instance = new S_Api();
//			}
		}
		return instance;
	}
	private S_Api(){
		super(API_KEY);
	}
//	public void save(){
//		try {
//		FileOutputStream f_out = new 
//			FileOutputStream("api.data");
//
//		ObjectOutputStream obj_out = new
//			ObjectOutputStream (f_out);
//
//			obj_out.writeObject ( S_Api.getInstance());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public static void load() throws IOException, ClassNotFoundException{
//		FileInputStream f_in = new 
//			FileInputStream("myobject.data");
//
//		ObjectInputStream obj_in = 
//			new ObjectInputStream (f_in);
//
//		Object obj = obj_in.readObject();
//
//		if (obj instanceof S_Api)
//		{
//			instance = (S_Api) obj;
//		}
//		else{
//			throw new ClassNotFoundException(); 
//		}
//	}
}
