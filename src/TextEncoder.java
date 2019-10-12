import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Implementation of a text encoder using Huffman Tree
 * 
 * @author Eduardo Andrade
 * @author Marcelo Heredia
 */
public class TextEncoder {
	private final String path = "input\\";
	private String fullPath;
	private String filename;

	/**
	 * Constructor method
	 * 
	 * @param filename name of file to encode
	 */
	public TextEncoder(String filename) {
		this.fullPath = path + filename;
		this.filename = filename;
	}

	/**
	 * Start codification
	 * 
	 * @return true for success or false for failure
	 */
	public boolean Start() {
		try {
			// file reading
			String fileText = PrintFrequencyMap(fullPath);
			// frequency count
			HashMap<Character, Integer> map = StringToFrequencyMap(fileText);
			// creating tree
			HuffmanTree tree = new HuffmanTree(map);
			// export code to hashmap
			HashMap<Character, String> code = tree.NodeTreeToCodeMap();
			// convert to string
			String encodedText = Codify(fileText, code);
			// replace text
			boolean isOk = FileOperations.WriteStringToFile(Paths.get(fullPath), encodedText);
			boolean isOk2 = SaveKeys(code, path, filename);

			return isOk && isOk2;

		}
		catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Codifies the text into a encoded text
	 * 
	 * @param text original text
	 * @param code codes
	 * @return encoded String
	 */
	private static String Codify(String text, HashMap<Character, String> code) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			Character letter = text.charAt(i);
			sb.append(code.get(letter));
		}
		return sb.toString();
	}

	/**
	 * Counts the frequency each character from the string appears.
	 * 
	 * @param input String to count frequency of each character
	 * @return a HashMap using the characters from input as keys and their
	 *         respective frequencies as values
	 */
	private static HashMap<Character, Integer> StringToFrequencyMap(String input) {
		HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			// Se existe estiver no mapa pega a frequencia atual, se nao comeca em 0
			int frequency = frequencyMap.containsKey(c) ? frequencyMap.get(c) : 0;
			// Adiciona no mapa somando a frequencia + 1
			frequencyMap.put(c, frequency + 1);
		}
		return frequencyMap;
	}

	/**
	 * put all the file's text into a string
	 * 
	 * @param path file
	 * @return returns the string with the text
	 * @throws Exception
	 */
	private static String PrintFrequencyMap(String path) throws Exception {
		String fileContent = "";
		fileContent = FileOperations.ReadFileToString(Paths.get(path));
		return fileContent;
	}

	private static boolean SaveKeys(HashMap<Character, String> keys, String path, String filename) {
		try {
			StringBuilder sb = new StringBuilder();
			String key;
			for (Entry<Character, String> entry : keys.entrySet()) {
				if (String.valueOf(entry.getKey()).matches("\r")) {
					key = "CR";
				}
				else if (String.valueOf(entry.getKey()).matches("\n")) {
					key = "LF";
				}
				else if (Character.isWhitespace(entry.getKey())) {
					key = "SP";
				}
				else {
					key = entry.getKey().toString();
				}
				sb.append(entry.getValue() + " " + key + "\n");
			}
			String newFileName = path + "key" + filename;
			boolean result = FileOperations.WriteStringToFile(Paths.get(newFileName), sb.toString());
			return result;
		}
		catch (Exception ex) {
			return false;
		}

	}
}
