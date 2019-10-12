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
			FileOperations.WriteStringToFile(Paths.get(fullPath), Decode(valueKeyMap, encodedText));
		}
		catch (Exception ex) {
			return false;
		}
		return true;
	}

	/**
	 * Decodes the encoded text using the provided map
	 * 
	 * @param codeMap     the map of codes and chars
	 * @param encodedText the encoded text
	 * @return the text decoded
	 */
	private String Decode(HashMap<String, Character> codeMap, String encodedText) {
		StringBuilder resultText = new StringBuilder();
		StringBuilder currentCode = new StringBuilder();

		for (int i = 0; i < encodedText.length(); i++) {
			currentCode.append(encodedText.charAt(i));
			if (codeMap.containsKey(currentCode.toString())) {
				resultText.append(codeMap.get(currentCode.toString()));
				currentCode.setLength(0);
			}
		}
		return resultText.toString();
	}

	/**
	 * Reads the generated keys file and turns it into a map
	 * 
	 * @param path caminho
	 * @return a map with the code as key and the character it represents as value
	 */
	private HashMap<String, Character> ReadKeys(String path) {
		try {

			HashMap<String, Character> map = new HashMap<String, Character>();
			List<String> texts = Files.readAllLines(Paths.get(path), StandardCharsets.US_ASCII);

			for (String text : texts) {
				String[] line = text.split(" ");
				String code = line[0];
				// the only char
				Character val = line[1].toCharArray()[0];
				map.put(code, val);
			}
			return map;
		}
		catch (Exception ex) {
			return null;
		}
	}
}