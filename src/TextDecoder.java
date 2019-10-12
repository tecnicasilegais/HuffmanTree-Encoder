import java.nio.file.Paths;
import java.util.HashMap;

public class TextDecoder {
	private final String path = "input\\";
    private String fullPath;
    private String keyFullPath;

    /**
     * Constructor
     * @param filename
     */
	public TextDecoder(String filename){
        this.fullPath = path + filename;
        this.keyFullPath = path + "key" + filename;
	}

    /**
     * start the execution
     * @return success or failure
     */
    public boolean Start(){
        try{
            //read encoded file
            String encodedText = FileOperations.ReadFileToString(Paths.get(fullPath));
            //read keys file
            HashMap<String,Character> valueKeyMap = ReadKeys(keyFullPath);
            //start comparations
        }
        catch(Exception ex){
            return false;
        }
    }
    
    
    private HashMap<String,Character> ReadKeys(String path){




        return null;
    }
}