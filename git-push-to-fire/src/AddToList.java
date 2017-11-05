/**
 * 
 * @author poisonphang
 * 
 * Add git repositors to active list
 *
 */
import org.json.simple.JSONObject;

public class AddToList {
	JSONObject obj;
	
	public AddToList() {
		obj = new JSONObject();
	}
	
	public void addItem(String projectName, String projectDirectory) {
		obj.put("project name", projectName);
		obj.put("project directory", projectDirectory);
	}
}
