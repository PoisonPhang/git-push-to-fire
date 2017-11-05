/**
 * 
 * @author poisonphang
 * 
 * Add git repositors to active list
 *
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.eclipse.jgit.lib.Repository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddToList {
	JSONArray list;
	JSONObject obj;
	Repository repo;
	String projectDir;
	
	public AddToList() {
		list = new JSONArray();
		obj = new JSONObject();
		projectDir = "";
	}
	
	public JSONObject getList() {
		return obj;
	}
	
	public void addItem(String projectDir) {
		list.add(projectDir);
	}
	
	public void saveToFile() {
		obj.put("ProjDirs", list);
		
		 try (FileWriter file = new FileWriter("ProjDirs.json")) {

	            file.write(obj.toJSONString());
	            file.flush();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	public void grabFromFile() {
		 JSONParser parser = new JSONParser();

	     try {

	    	 Object savedObj = parser.parse(new FileReader("ProjDirs.json"));

	         JSONObject obj = (JSONObject) savedObj;
	         System.out.println(obj);
	         
	         JSONArray tempStore = (JSONArray) obj.get("ProjDirs.json");
	            Iterator<String> iterator = tempStore.iterator();
	            while (iterator.hasNext()) {
	                list.add((iterator.next()));
	            }
	         } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            } catch (IOException e) {
	            e.printStackTrace();
	            } catch (ParseException e) {
	            e.printStackTrace();
	            }
	     }
}
