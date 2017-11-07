/**
 * 
 * @author poisonphang
 * 
 * Grabs stored git repository paths and moves between them to commit/push each one
 *
 */
import org.json.simple.JSONObject;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

class Pusher {
	private Repository repo;
	private final String TAG = "Pusher: ";
	private String repositroyPath;
	private FileRepositoryBuilder repBuilder;
	
	Pusher() {
		repositroyPath = "";
		repBuilder = new FileRepositoryBuilder();
		}
	
	void commitAndPush() {
		Git git = new Git(repo);
		git.commit().setMessage("Emergency");
		git.push();
	}
	
	void assignRepo() {
		
		repBuilder.setMustExist(true);
		repBuilder.setGitDir(new File(repositroyPath));
		try {
			repo = repBuilder.build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void debugOutput(Process process) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		String line;
		try {
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
