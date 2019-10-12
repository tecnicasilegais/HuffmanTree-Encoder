import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class TextDecoder {
    private final String path = "input\\";
    private String fullPath;
    private String keyFullPath;

    /**
     * Constructor
     * 
     * @param filename
     */
    public TextDecoder(String filename) {
        this.fullPath = path + filename;
        this.keyFullPath = path + "key" + filename;
    }

    /**
     * start the execution
     * 
     * @return success or failure
     */
    public boolean Start() {
        try {
            // read encoded file
            String encodedText = FileOperations.ReadFileToString(Paths.get(fullPath));
            // read keys file
            HashMap<String, Character> valueKeyMap = ReadKeys(keyFullPath);
            // start comparations
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Ler chaves
     * 
     * @param path caminho
     * @return
     */
    private HashMap<String, Character> ReadKeys(String path) {
        try {

            HashMap<String, Character> map = new HashMap<String,Character>();
            List<String> texts = Files.readAllLines(Paths.get(path), StandardCharsets.US_ASCII);

            for (String text : texts){
                String [] line = text.split(" ");
                String code = line[0];
                //the only char
                Character val = line[1].toCharArray()[0];
                map.put(code, val);
            }
            return map;
        } catch (Exception ex) {
            return null;
        }
    }
}