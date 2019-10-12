import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Implementation of a Huffman Tree
 * 
 * @author Eduardo Andrade
 * @author Marcelo Heredia
 */
public class HuffmanTree {
	HashMap<Character, Integer> map;
	PriorityQueue<Node> queue;

	private class Node implements Comparable<Node> {
		private Character character;
		private Integer frequency;
		private Node left;
		private Node right;

		public Node(Character character, Integer frequency) {
			this.character = character;
			this.frequency = frequency;
			this.left = null;
			this.right = null;
		}

		public Node(Character character, Integer frequency, Node left, Node right) {
			this.character = character;
			this.frequency = frequency;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.frequency, n.frequency);
		}

		public boolean hasCharacter() {
			return this.character != null;
		}

		public boolean hasLeft() {
			return this.left != null;
		}

		public boolean hasRight() {
			return this.right != null;
		}

	}

	public HuffmanTree(HashMap<Character, Integer> map) {
		this.map = map;
		queue = this.MapToNodeTree(map);
	}

	public HashMap<Character, String> NodeTreeToCodeMap() {
		HashMap<Character, String> codeMap;
		Node root
	}

	private PriorityQueue<Node> MapToNodeTree(HashMap<Character, Integer> hashMap) {
		PriorityQueue<Node> tempQueue = new PriorityQueue<Node>();
		for (Entry<Character, Integer> entry : map.entrySet()) {
			tempQueue.add(new Node(entry.getKey(), entry.getValue()));
		}

		while (tempQueue.size() >= 2) {
			Node[] removed = { tempQueue.poll(), tempQueue.poll() };
			int frequencySum = removed[0].frequency + removed[1].frequency;
			Node newNode = new Node(null, frequencySum, removed[0], removed[1]);
			tempQueue.add(newNode);
		}

		return tempQueue;
	}

}
