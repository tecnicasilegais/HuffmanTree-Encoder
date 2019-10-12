import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
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
	public static void main(String[] args) {
		String path = "input\\teste.txt";
		PrintCodeMap(path);
		// PrintFrequencyMap(path);
	}

	/**
	 * Counts the frequency each character from the string appears.
	 * 
	 * @param input String to count frequency of each character
	 * @return a HashMap using the characters from input as keys and their
	 *         respective frequencies as values
	 */
	public static HashMap<Character, Integer> StringToFrequencyMap(String input) {
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

	private static void PrintCodeMap(String path) {
		String fileContent = "";

		try {
			fileContent = FileOperations.ReadFileToString(Paths.get(path));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		HuffmanTree tree = new HuffmanTree(StringToFrequencyMap(fileContent));
		HashMap<Character, String> codeMap = tree.NodeTreeToCodeMap();

		for (Entry<Character, String> entry : codeMap.entrySet()) {
			if (String.valueOf(entry.getKey()).matches("\r")) {
				System.out.println("CR\t-\t" + entry.getValue());
			}
			else if (String.valueOf(entry.getKey()).matches("\n")) {
				System.out.println("LF\t-\t" + entry.getValue());
			}
			else if (Character.isWhitespace(entry.getKey())) {
				System.out.println("SP\t-\t" + entry.getValue());
			}
			else {
				System.out.println(entry.getKey() + "\t-\t" + entry.getValue());
			}
		}
	}

	private static void PrintFrequencyMap(String path) {
		String fileContent = "";
		try {
			fileContent = FileOperations.ReadFileToString(Paths.get(path));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		HashMap<Character, Integer> map = StringToFrequencyMap(fileContent);
		for (Character c : map.keySet()) {
			if (String.valueOf(c).matches("\r")) {
				System.out.println("CR\t-\t" + map.get(c));
			}
			else if (String.valueOf(c).matches("\n")) {
				System.out.println("LF\t-\t" + map.get(c));
			}
			else if (Character.isWhitespace(c)) {
				System.out.println("Space\t-\t" + map.get(c));
			}
			else {
				System.out.println(c + "\t-\t" + map.get(c));
			}
		}
	}
}
