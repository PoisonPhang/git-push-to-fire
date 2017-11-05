/**
 * 
 * @author poisonphang
 * 
 * Grabs stored git repository paths and moves between them to commit/push each one
 *
 */
import org.json.simple.JSONObject;

public class Pusher {
	private String repositroyPath;
	private String projectName;
	
	public Pusher() {
		repositroyPath = "";
		projectName = "";
	}
}
