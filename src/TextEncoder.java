import java.util.HashMap;

/**
 * Implementation of a text encoder using Huffman Tree
 * 
 * @author Eduardo Andrade
 * @author Marcelo Heredia
 */
public class TextEncoder {
	/**
	 * Counts the frequency each character from the string appears.
	 * 
	 * @param input String to count frequency of each character
	 * @return a HashMap using the characters from input as keys and their
	 *         respective frequencies as values
	 */
	public HashMap<Character, Integer> StringToFrequencyMap(String input) {
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
}
